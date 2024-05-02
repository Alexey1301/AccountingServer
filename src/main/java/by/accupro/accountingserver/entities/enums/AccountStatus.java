package by.accupro.accountingserver.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountStatus {

    ACTIVE("active"),
    FREEZE("freeze"),
    CANCELLED("cancelled"),
    ;

    private final String status;

}
