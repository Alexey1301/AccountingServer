package by.accupro.accountingserver.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private String type;
    private String currency;
    private double balance;
    private String status;
}
