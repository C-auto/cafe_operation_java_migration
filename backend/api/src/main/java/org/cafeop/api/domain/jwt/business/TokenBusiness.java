package org.cafeop.api.domain.jwt.business;

import lombok.RequiredArgsConstructor;
import org.cafeop.api.common.annotation.Business;
import org.cafeop.api.common.error.ErrorCode;
import org.cafeop.api.common.exception.ApiException;
import org.cafeop.api.domain.jwt.converter.TokenConverter;
import org.cafeop.api.domain.jwt.model.TokenResponse;
import org.cafeop.api.domain.jwt.service.TokenService;
import org.cafeop.db.user.UserEntity;

import java.util.Optional;

@Business
@RequiredArgsConstructor
public class TokenBusiness {
    private final TokenService tokenService;
    private final TokenConverter tokenConverter;


    public TokenResponse issueToken(UserEntity userEntity) {
        return Optional.ofNullable(userEntity)
                .map(ue -> {
                    return ue.getPhoneNumber();
                })
                .map(phoneNumber -> {
                    var accessToken = tokenService.issueAccessToken(phoneNumber);
                    var refreshToken = tokenService.issueRefreshToken(phoneNumber);
                    return tokenConverter.toResponse(accessToken,refreshToken);
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT));
    }
}
