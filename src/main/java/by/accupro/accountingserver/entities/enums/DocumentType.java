package by.accupro.accountingserver.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {
    INVOICE("invoice"),
    CONTRACT("contract"),
    ACT("act"),
    ;

    private final String type;
}
