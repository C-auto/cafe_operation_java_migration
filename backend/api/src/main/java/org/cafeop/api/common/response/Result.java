package org.cafeop.api.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer resultCode;

    private String resultMessage;

    public static Result ok() {
        return Result.builder()
                .resultCode(200)
                .resultMessage("ok")
                .build();
    }

}
