package org.cafeop.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorCodeIfs{

    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), 400, "User not found.")
    ;

    private final Integer httpStatusCode;

    private final Integer errorCode;

    private final String message;
}
