package org.cafeop.db.user;

import org.cafeop.db.user.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // SELECT * FROM user_auth WHERE phone_number = ? AND password = ? AND status = ? ORDER BY seq DESC LIMIT 1
    Optional<UserEntity> findFirstByPhoneNumberAndPasswordAndStatusOrderBySeqDesc(String phoneNumber, String password, UserStatus status);

    // SELECT * FROM user_auth WHERE phone_number = ? AND status =? ORDER By seq DESC LIMIT 1
    Optional<UserEntity> findFirstByPhoneNumberAndStatusOrderBySeqDesc(String phoneNumber, UserStatus status);
}
