package tech.henskens.portfolioservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.henskens.portfolioservice.dto.AccountResponse;
import tech.henskens.portfolioservice.dto.LoginRequest;
import tech.henskens.portfolioservice.model.Account;
import tech.henskens.portfolioservice.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponse> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        if (accountService.validateLogin(loginRequest)) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Incorrect credentials", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody Account account) {
        accountService.registerUser(account);
        return ResponseEntity.ok("User registered successfully");
    }

}
