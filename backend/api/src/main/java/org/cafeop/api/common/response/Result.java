package org.cafeop.api.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cafeop.api.common.error.ErrorCode;
import org.cafeop.api.common.error.ErrorCodeIfs;

@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer code;

    private String message;

    public static Result ok() {
        return Result.builder()
                .code(200)
                .message("ok")
                .build();
    }

    public static Result ERROR(ErrorCodeIfs errorCodeIfs) {
        return Result.builder()
                .code(errorCodeIfs.getErrorCode())
                .message(errorCodeIfs.getMessage())
                .build();
    }

    public static Result ERROR(ErrorCodeIfs errorCodeIfs, Throwable tx) {
        return Result.builder()
                .code(errorCodeIfs.getErrorCode())
                .message(errorCodeIfs.getMessage())
                .build();
    }

    public static Result ERROR(ErrorCodeIfs errorCodeIfs, String detailMessage) {
        return Result.builder()
                .code(errorCodeIfs.getErrorCode())
                .message(detailMessage)
                .build();
    }



}
