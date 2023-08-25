package org.cafeop.api.common.exception;

import lombok.Getter;
import org.cafeop.api.common.error.ErrorCodeIfs;

@Getter
public class ApiException extends RuntimeException implements ApiExceptionIfs{
    private final ErrorCodeIfs errorCodeIfs;
    private final String errorMessage;

    public ApiException(ErrorCodeIfs errorCodeIfs) {
        super(errorCodeIfs.getMessage());
        this.errorCodeIfs = errorCodeIfs;
        this.errorMessage = errorCodeIfs.getMessage();
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, String errorMessage) {
        super(errorMessage);
        this.errorCodeIfs = errorCodeIfs;
        this.errorMessage = errorMessage;
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorMessage = errorCodeIfs.getMessage();
    }

    public ApiException(ErrorCodeIfs errorCodeIfs, Throwable tx, String errorMessage) {
        super(tx);
        this.errorCodeIfs = errorCodeIfs;
        this.errorMessage = errorMessage;
    }


}
