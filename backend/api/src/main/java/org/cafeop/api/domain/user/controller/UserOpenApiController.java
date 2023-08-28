package org.cafeop.api.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cafeop.api.common.response.Api;
import org.cafeop.api.domain.jwt.model.TokenResponse;
import org.cafeop.api.domain.user.business.UserBusiness;
import org.cafeop.api.domain.user.controller.model.UserLoginRequest;
import org.cafeop.api.domain.user.controller.model.UserRegisterRequest;
import org.cafeop.api.domain.user.controller.model.UserResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/open-api/user")
public class UserOpenApiController {

    private final UserBusiness userBusiness;


    @PostMapping("/register")
    public Api<UserResponse> register(
            @Valid
            @RequestBody Api<UserRegisterRequest> request
    ) {
        var response = userBusiness.register(request.getData());
        return Api.ok(response);

    }

    @PostMapping("/login")
    public Api<TokenResponse> login(
            @Valid
            @RequestBody Api<UserLoginRequest> request
    ) {
        var response = userBusiness.login(request.getData());
        return Api.ok(response);
    }
}