package org.cafeop.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum TokenErrorCode implements ErrorCodeIfs{
    INVALID_TOKEN(HttpStatus.BAD_REQUEST.value(), 2000, "Invalid token."),
    EXPIRED_TOKEN(HttpStatus.BAD_REQUEST.value(), 2001, "Expired token."),
    TOKEN_EXCEPTION(HttpStatus.BAD_REQUEST.value(), 2002, "Unknown token error.")
    ;

    private final Integer httpStatusCode;

    private final Integer errorCode;

    private final String message;
}
