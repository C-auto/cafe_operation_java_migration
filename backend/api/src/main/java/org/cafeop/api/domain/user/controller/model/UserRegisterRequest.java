package org.cafeop.api.domain.user.controller.model;

import lombok.*;
import org.cafeop.api.common.annotation.PhoneNumber;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

    @PhoneNumber
    private String phoneNumber;

    @NotBlank
    private String password;

}
