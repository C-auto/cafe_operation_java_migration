package org.cafeop.api.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.cafeop.api.common.annotation.UserSession;
import org.cafeop.api.common.response.Api;
import org.cafeop.api.domain.user.business.UserBusiness;
import org.cafeop.api.domain.user.controller.model.User;
import org.cafeop.api.domain.user.controller.model.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserBusiness userBusiness;

    @GetMapping("/test")
    public Api<UserResponse> test(
            @UserSession User user
            ) {
        var response = userBusiness.tokenTest(user);
        return Api.ok(response);
    }

}
