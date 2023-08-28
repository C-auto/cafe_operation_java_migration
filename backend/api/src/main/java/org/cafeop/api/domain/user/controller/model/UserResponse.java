package org.cafeop.api.domain.user.controller.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponse {
    private String phoneNumber;

//    private String password;

    private LocalDateTime registeredAt;
}
