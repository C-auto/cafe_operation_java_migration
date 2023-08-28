package org.cafeop.api.domain.user.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cafeop.api.common.annotation.PhoneNumber;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

    @PhoneNumber
    private String phone_number;

    @NotBlank
    private String password;

}
