package org.cafeop.db.user.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserStatus {
    REGISTERED("Registered user"),
    UNREGISTERED("Deleted user")

    ;
    private final String description;
}
