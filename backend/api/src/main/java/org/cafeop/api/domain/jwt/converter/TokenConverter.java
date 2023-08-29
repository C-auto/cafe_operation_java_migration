package org.cafeop.api.domain.jwt.converter;

import lombok.RequiredArgsConstructor;
import org.cafeop.api.common.annotation.Converter;
import org.cafeop.api.common.error.ErrorCode;
import org.cafeop.api.common.exception.ApiException;
import org.cafeop.api.domain.jwt.model.TokenDto;
import org.cafeop.api.domain.jwt.model.TokenResponse;

import java.util.Objects;

@Converter
@RequiredArgsConstructor
public class TokenConverter {

    public TokenResponse toResponse(
            TokenDto accessToken,
            TokenDto refreshToken
    ) {
        Objects.requireNonNull(accessToken, () -> {
            throw new ApiException(ErrorCode.NULL_POINT);
        });
        Objects.requireNonNull(refreshToken, () -> {
            throw new ApiException(ErrorCode.NULL_POINT);
        });

        return TokenResponse.builder()
                .accessToken(accessToken.getToken())
                .accessTokenExpiredAt(accessToken.getExpiredAt())
                .refreshToken(refreshToken.getToken())
                .refreshTokenExpiredAt(refreshToken.getExpiredAt())
                .build();
    }
}
