package org.cafeop.api.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.cafeop.api.common.error.ErrorCode;
import org.cafeop.api.common.exception.ApiException;
import org.cafeop.api.common.response.Api;
import org.cafeop.api.domain.user.controller.model.UserResponse;
import org.cafeop.db.user.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/open-api/user")
public class UserOpenApiController {

    @GetMapping("/test")
    public Api<UserResponse> test() {
        var response = UserResponse.builder()
                .phoneNumber("010-8892-1870")
                .password("1234")
                .registeredAt(LocalDateTime.now())
                .build();

        // Exception test
        var str = "hello";
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            throw new ApiException(ErrorCode.SERVER_ERROR, e);
        }

        return Api.ok(response);
    }
}
