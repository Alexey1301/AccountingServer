package by.accupro.accountingserver.controllers;

import by.accupro.accountingserver.dto.ContractorDTO;
import by.accupro.accountingserver.entities.Contractor;
import by.accupro.accountingserver.services.ContractorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contractor")
public class ContractorController {

    private final ContractorService contractorService;
    private final ModelMapper modelMapper;

    @Autowired
    public ContractorController(ContractorService contractorService, ModelMapper modelMapper) {
        this.contractorService = contractorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createContractor(@RequestBody ContractorDTO contractorDTO) {
        contractorService.save(convertToContractor(contractorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Contractor convertToContractor(ContractorDTO contractorDTO) {
        return modelMapper.map(contractorDTO, Contractor.class);
    }
}
