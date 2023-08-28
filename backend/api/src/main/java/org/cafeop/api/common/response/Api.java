package org.cafeop.api.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cafeop.api.common.error.ErrorCodeIfs;

import javax.validation.Valid;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {
    private Result meta;

    @Valid
    private T data;

    public static <T> Api<T> ok(T data) {
        var api = new Api<T>();
        api.meta = Result.ok();
        api.data = data;
        return api;
    }

    public static Api<Object> ERROR(String errorMessage) {
        var api = new Api<Object>();
        api.meta = Result.ERROR(errorMessage);
        api.data = null;
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs) {
        var api = new Api<Object>();
        api.meta = Result.ERROR(errorCodeIfs);
        api.data = null;
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        var api = new Api<Object>();
        api.meta = Result.ERROR(errorCodeIfs, tx);
        api.data = null;
        return api;
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorCodeIfs, String description) {
        var api = new Api<Object>();
        api.meta = Result.ERROR(errorCodeIfs, description);
        api.data = null;
        return api;
    }
}
