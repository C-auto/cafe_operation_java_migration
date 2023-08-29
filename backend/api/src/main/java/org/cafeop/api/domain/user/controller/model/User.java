package org.cafeop.api.domain.user.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cafeop.db.user.enums.UserStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long seq;

    private String phoneNumber;

    private String password;

    private UserStatus status;

    private LocalDateTime registeredAt;
}
