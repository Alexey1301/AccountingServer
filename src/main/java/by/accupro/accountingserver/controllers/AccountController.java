package by.accupro.accountingserver.controllers;

import by.accupro.accountingserver.dto.AccountDTO;
import by.accupro.accountingserver.entities.Account;
import by.accupro.accountingserver.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final ModelMapper modelMapper;

    @Autowired
    public AccountController(AccountService accountService, ModelMapper modelMapper) {
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createAccount(@RequestBody AccountDTO accountDTO) {
        accountService.save(convertToAccount(accountDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<HttpStatus> updateAccount(@RequestBody AccountDTO accountDTO, @PathVariable("id") int id) {
        accountService.update(id, convertToAccount(accountDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Account convertToAccount(AccountDTO accountDTO) {
        return modelMapper.map(accountDTO, Account.class);
    }
}
