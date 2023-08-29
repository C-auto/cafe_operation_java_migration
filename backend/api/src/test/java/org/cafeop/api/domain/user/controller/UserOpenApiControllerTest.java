package org.cafeop.api.domain.user.controller;

import org.cafeop.api.domain.user.controller.model.UserRegisterRequest;
import org.cafeop.api.domain.user.controller.model.UserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserOpenApiControllerTest {

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("사용자 등록 테스트")
    void register() {
        System.out.println("## User register");

        String phoneNumber = "010-5555-5555";
        String password = "1234";

        String root_path = "http://localhost:" + port;

        URI uri = UriComponentsBuilder
                .fromUriString(root_path)
                .path("/open-api/user/register")
                .build()
                .toUri();

        UserRegisterRequest userDto = new UserRegisterRequest();
        userDto.setPhoneNumber(phoneNumber);
        userDto.setPassword(password);

        // TODO : Test 오류 해결 Null Point

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserResponse> responseEntity =  restTemplate.postForEntity(uri, userDto, UserResponse.class);

        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getHeaders());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

//    @Test
//    void login() {
//    }
}