package org.cafeop.db.user;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.cafeop.db.BaseEntity;
import org.cafeop.db.user.enums.UserStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_auth")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {

    @Column(length = 200, nullable = false)
    private String phoneNumber;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(nullable = false)
    private LocalDateTime registeredAt;
}
