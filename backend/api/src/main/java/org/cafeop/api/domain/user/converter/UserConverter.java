package org.cafeop.api.domain.user.converter;

import lombok.RequiredArgsConstructor;
import org.cafeop.api.common.annotation.Converter;
import org.cafeop.api.common.error.ErrorCode;
import org.cafeop.api.common.exception.ApiException;
import org.cafeop.api.domain.user.controller.model.UserRegisterRequest;
import org.cafeop.api.domain.user.controller.model.UserResponse;
import org.cafeop.db.user.UserEntity;

import java.util.Optional;

@Converter
@RequiredArgsConstructor
public class UserConverter {

    public UserEntity toEntity(UserRegisterRequest request) {
        return Optional.ofNullable(request)
                .map(it -> {
                    return UserEntity.builder()
                            .phoneNumber(request.getPhoneNumber())
                            .password(request.getPassword())
                            .build();
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null."));
    }

    public UserResponse toResponse(UserEntity userEntity) {
        return Optional.ofNullable(userEntity)
                .map(it -> {
                    return UserResponse.builder()
                            .phoneNumber(userEntity.getPhoneNumber())
                            .registeredAt(userEntity.getRegisteredAt())
                            .build();
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "UserEntity Null."));
    }

}
