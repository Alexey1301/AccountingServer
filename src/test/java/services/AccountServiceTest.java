package services;

import by.accupro.accountingserver.entities.Account;
import by.accupro.accountingserver.repositories.AccountRepository;
import by.accupro.accountingserver.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    public void testSave() {
        // Arrange
        Account accountToSave = new Account();
        accountToSave.setType("Type");
        accountToSave.setCurrency("USD");
        accountToSave.setBalance(1000.0);
        accountToSave.setStatus("Active");

        // Act
        accountService.save(accountToSave);

        // Assert
        verify(accountRepository, times(1)).save(accountToSave);
        assertEquals("Type", accountToSave.getType());
        assertEquals("USD", accountToSave.getCurrency());
        assertEquals(1000.0, accountToSave.getBalance());
        assertEquals("Active", accountToSave.getStatus());
    }

    @Test
    public void testUpdate() {
        // Arrange
        int accountId = 1;
        Account updatedAccount = new Account();
        updatedAccount.setId(accountId); // Установим ID, чтобы метод update сработал корректно
        updatedAccount.setType("Type");
        updatedAccount.setCurrency("EUR");
        updatedAccount.setBalance(2000.0);
        updatedAccount.setStatus("Inactive");

        // Act
        accountService.update(accountId, updatedAccount);

        // Assert
        verify(accountRepository, times(1)).save(updatedAccount);
        assertEquals(accountId, updatedAccount.getId());
        assertEquals("Type", updatedAccount.getType());
        assertEquals("EUR", updatedAccount.getCurrency());
        assertEquals(2000.0, updatedAccount.getBalance());
        assertEquals("Inactive", updatedAccount.getStatus());
    }
}

