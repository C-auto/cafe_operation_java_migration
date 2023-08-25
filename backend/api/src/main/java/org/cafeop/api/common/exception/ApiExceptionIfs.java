package org.cafeop.api.common.exception;

import org.cafeop.api.common.error.ErrorCodeIfs;

public interface ApiExceptionIfs {
    ErrorCodeIfs getErrorCodeIfs();

    String getErrorMessage();
}
