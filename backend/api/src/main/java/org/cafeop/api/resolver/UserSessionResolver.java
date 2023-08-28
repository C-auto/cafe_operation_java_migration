package org.cafeop.api.resolver;

import lombok.RequiredArgsConstructor;
import org.cafeop.api.common.annotation.UserSession;
import org.cafeop.api.domain.user.controller.model.User;
import org.cafeop.api.domain.user.service.UserService;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@RequiredArgsConstructor
public class UserSessionResolver implements HandlerMethodArgumentResolver {
    private final UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // annotation check
        var annotation = parameter.hasParameterAnnotation(UserSession.class);
        // parameter type check
        var parameterType = parameter.getParameterType().equals(User.class);
        return (annotation && parameterType);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // request holder
        var requestContext = RequestContextHolder.getRequestAttributes();
        var phoneNumber = requestContext.getAttribute("phoneNumber", RequestAttributes.SCOPE_REQUEST);
        var userEntity = userService.getUserWithThrow(phoneNumber.toString());

        return User.builder()
                .phoneNumber(userEntity.getPhoneNumber())
                .password(userEntity.getPassword())
                .status(userEntity.getStatus())
                .registeredAt(userEntity.getRegisteredAt())
                .build();
    }
}
