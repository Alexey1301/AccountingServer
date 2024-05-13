package services;

import by.accupro.accountingserver.entities.Contractor;
import by.accupro.accountingserver.repositories.ContractorRepository;
import by.accupro.accountingserver.services.ContractorService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ContractorServiceTest {

    @Mock
    private ContractorRepository contractorRepository;

    @InjectMocks
    private ContractorService contractorService;

    @Test
    public void testSave() {
        Contractor contractorToSave = new Contractor();
        contractorToSave.setType("Type");
        contractorToSave.setName("Name");
        contractorToSave.setTIN(123456789);
        contractorToSave.setAddress("Address");
        contractorToSave.setPhone("Phone");

        ArgumentCaptor<Contractor> contractorCaptor = ArgumentCaptor.forClass(Contractor.class);

        contractorService.save(contractorToSave);

        verify(contractorRepository, times(1)).save(contractorCaptor.capture());

        Contractor savedContractor = contractorCaptor.getValue();

        assertEquals(contractorToSave.getType(), savedContractor.getType());
        assertEquals(contractorToSave.getName(), savedContractor.getName());
        assertEquals(contractorToSave.getTIN(), savedContractor.getTIN());
        assertEquals(contractorToSave.getAddress(), savedContractor.getAddress());
        assertEquals(contractorToSave.getPhone(), savedContractor.getPhone());
    }
}

