package org.cafeop.api.common.exception;

import lombok.extern.slf4j.Slf4j;

import org.cafeop.api.common.response.Api;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Api<Object>> apiException(
            ApiException apiException
    ) {
        log.error("", apiException);

        var errorCode = apiException.getErrorCodeIfs();

        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                .body(Api.ERROR(errorCode, apiException.getErrorMessage()));
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class})
    public ResponseEntity<Api<Object>> validationException(
            MethodArgumentNotValidException exception
    ) {
        var errorMessage = exception.getFieldError().getDefaultMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST.value())
                .body(Api.ERROR(errorMessage));
    }
}
