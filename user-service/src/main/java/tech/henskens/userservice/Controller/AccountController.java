package tech.henskens.userservice.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.henskens.userservice.Service.AccountService;
import tech.henskens.userservice.dto.AccountByEmail;
import tech.henskens.userservice.dto.AccountResponse;
import tech.henskens.userservice.dto.LoginRequest;
import tech.henskens.userservice.model.Account;

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

    @GetMapping("/account/{emailAddress}")
    public ResponseEntity<AccountByEmail> getAccountByEmail(@PathVariable("emailAddress") String emailAddress) {
        AccountByEmail accountDTO = accountService.findByEmailAddress(emailAddress);

        if (accountDTO != null) {
            return new ResponseEntity<>(accountDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        if (accountService.validateLogin(loginRequest)) {
            accountService.updateLastLogin(loginRequest.getEmail());
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
