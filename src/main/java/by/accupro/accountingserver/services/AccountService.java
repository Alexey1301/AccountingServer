package by.accupro.accountingserver.services;

import by.accupro.accountingserver.entities.Account;
import by.accupro.accountingserver.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public void update(int id, Account updatedAccount) {
        updatedAccount.setId(id);
        accountRepository.save(updatedAccount);
    }

}
