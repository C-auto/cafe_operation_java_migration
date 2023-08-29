package org.cafeop.api.domain.jwt.service;

import lombok.RequiredArgsConstructor;
import org.cafeop.api.common.error.ErrorCode;
import org.cafeop.api.common.exception.ApiException;
import org.cafeop.api.domain.jwt.ifs.TokenHelperIfs;
import org.cafeop.api.domain.jwt.model.TokenDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenHelperIfs tokenHelperIfs;

    public TokenDto issueAccessToken(String phoneNumber) {
        var data = new HashMap<String, Object>();
        data.put("phoneNumber", phoneNumber);
        return tokenHelperIfs.issueAccessToken(data);
    }

    public TokenDto issueRefreshToken(String phoneNumber) {
        var data = new HashMap<String, Object>();
        data.put("phoneNumber", phoneNumber);
        return tokenHelperIfs.issueRefreshToken(data);
    }

    public String validationToken(String token) {
        var map = tokenHelperIfs.validationTokenWithThrow(token);
        var phoneNumber = map.get("phoneNumber");

        Objects.requireNonNull(phoneNumber, () -> {throw  new ApiException(ErrorCode.NULL_POINT);
        });

        return phoneNumber.toString();
    }



}
