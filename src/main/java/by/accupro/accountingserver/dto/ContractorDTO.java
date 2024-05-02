package by.accupro.accountingserver.dto;

import lombok.Data;

@Data
public class ContractorDTO {
    private String type;
    private String name;
    private int TIN;
    private String address;
    private String phone;
}
