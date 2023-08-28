package org.cafeop.api.domain.user.business;

import lombok.RequiredArgsConstructor;
import org.cafeop.api.common.annotation.Business;
import org.cafeop.api.domain.jwt.business.TokenBusiness;
import org.cafeop.api.domain.jwt.model.TokenResponse;
import org.cafeop.api.domain.user.controller.model.UserLoginRequest;
import org.cafeop.api.domain.user.controller.model.UserRegisterRequest;
import org.cafeop.api.domain.user.controller.model.UserResponse;
import org.cafeop.api.domain.user.converter.UserConverter;
import org.cafeop.api.domain.user.service.UserService;

@Business
@RequiredArgsConstructor
public class UserBusiness {
    private final UserService userService;
    private final UserConverter userConverter;
    private final TokenBusiness tokenBusiness;

    /*
    * 1. 사용자 입력 Request -> entity
    * 2. entity -> save
    * 3. save entity -> response
    * 4. response return
    * */
    public UserResponse register(UserRegisterRequest request) {
        var entity = userConverter.toEntity(request);
        var newEntity = userService.register(entity);
        return userConverter.toResponse(newEntity);

    }

    public TokenResponse login(UserLoginRequest request) {
        var entity = userService.login(request.getPhoneNumber(), request.getPassword());
        return tokenBusiness.issueToken(entity);
    }

}
