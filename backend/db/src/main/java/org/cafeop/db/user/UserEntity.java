package org.cafeop.db.user;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.cafeop.db.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @Column(nullable = false)
    private LocalDateTime registeredAt;
}
