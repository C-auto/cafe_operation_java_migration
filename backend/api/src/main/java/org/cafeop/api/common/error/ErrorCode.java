package org.cafeop.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode implements ErrorCodeIfs{
    OK(HttpStatus.OK.value(), 200, "ok"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), 400, "Wrong request."),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), 500, "Server error."),
    NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(), 512, "Server error.")
    ;

    private final Integer httpStatusCode;

    private final Integer errorCode;

    private final String message;

    // Getter Method
}
