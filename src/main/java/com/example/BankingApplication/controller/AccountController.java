package com.example.BankingApplication.controller;

import com.example.BankingApplication.entity.Account;
import com.example.BankingApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/{id}/create")
    public Account createAccount(@PathVariable Long id, @RequestBody Map<String, Object> request) {
        String name = (String) request.get("accountHolderName");
        Double balance = Double.valueOf(request.get("balance").toString()); // Handle conversion safely
        return accountService.createAccount(id, name, balance);
    }


    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map request) {
        Double amount = (Double) request.get("amount");
        return accountService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestBody Map request) {
        Double amount = (Double) request.get("amount");
        return accountService.withdraw(id, amount);
    }
}
