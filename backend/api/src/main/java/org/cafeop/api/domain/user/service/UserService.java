package org.cafeop.api.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.cafeop.api.common.error.ErrorCode;
import org.cafeop.api.common.error.UserErrorCode;
import org.cafeop.api.common.exception.ApiException;
import org.cafeop.db.user.UserEntity;
import org.cafeop.db.user.UserRepository;
import org.cafeop.db.user.enums.UserStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity register(UserEntity userEntity) {
        return Optional.ofNullable(userEntity)
                .map(it -> {
                    userEntity.setStatus(UserStatus.REGISTERED);
                    userEntity.setRegisteredAt(LocalDateTime.now());
                    return userRepository.save(userEntity);
                }).orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "User Entity Null"));
    }

    public UserEntity login(
            String phoneNumber,
            String password
    ) {
        return userRepository.findFirstByPhoneNumberAndPasswordAndStatusOrderBySeqDesc(
                phoneNumber,
                password,
                UserStatus.REGISTERED
        ).orElseThrow(() -> new ApiException(UserErrorCode.USER_NOT_FOUND));
    }


}
