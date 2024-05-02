package by.accupro.accountingserver.dto;

import by.accupro.accountingserver.entities.Account;
import by.accupro.accountingserver.entities.Contractor;
import lombok.Data;

import java.util.Date;

@Data
public class DocumentDTO {

    private String type;
    private Date date;
    private Contractor contactor;
    private Account account;
    private double sum;
}
