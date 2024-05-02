package by.accupro.accountingserver.services;

import by.accupro.accountingserver.entities.Contractor;
import by.accupro.accountingserver.repositories.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractorService {
    private final ContractorRepository contractorRepository;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    public void save(Contractor contractor) {
        contractorRepository.save(contractor);
    }
}
