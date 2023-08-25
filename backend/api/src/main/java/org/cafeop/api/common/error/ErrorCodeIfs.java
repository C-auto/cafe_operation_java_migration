package org.cafeop.api.common.error;

public interface ErrorCodeIfs {
    Integer getHttpStatusCode();

    Integer getErrorCode();

    String getMessage();
}
