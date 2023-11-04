package tech.henskens.portfolioservice.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.henskens.portfolioservice.dto.AccountResponse;
import tech.henskens.portfolioservice.dto.LoginRequest;
import tech.henskens.portfolioservice.model.Account;
import tech.henskens.portfolioservice.repository.AccountRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;


    @PostConstruct
    public void loadData() {
        if (accountRepository.count() == 0) {
            Account account1 = new Account();
            account1.setId("user1");
            account1.setFirstName("Peter");
            account1.setLastName("Henskens");
            account1.setEmailAddress("peter.henskens@gmail.com");
            account1.setHashPassword("password");
            account1.setPhoneNumber("0488.12.13.14");
            account1.setRole("admin");
            account1.setUpdated(LocalDateTime.now());
            accountRepository.save(account1);

            Account account2 = new Account();
            account2.setId("user2");
            account2.setFirstName("Lisa");
            account2.setLastName("Wouters");
            account2.setEmailAddress("lisawouters@gmail.com");
            account2.setHashPassword("password");
            account2.setPhoneNumber("0488.12.13.14");
            account2.setRole("user");
            account2.setUpdated(LocalDateTime.now());
            accountRepository.save(account2);

        }
    }

    public List<AccountResponse> getAllAccounts() {
        Iterable<Account> accounts = accountRepository.findAll();
        List<Account> accountList = StreamSupport
                .stream(accounts.spliterator(), false)
                .toList();

        return accountList.stream()
                .map(this::mapToAccountResponse)
                .collect(Collectors.toList());
    }

    private AccountResponse mapToAccountResponse(Account account) {
        AccountResponse response = new AccountResponse();
        response.setFirstName(account.getFirstName());
        response.setLastName(account.getLastName());
        response.setEmailAddress(account.getEmailAddress());
        response.setHashPassword(account.getHashPassword());
        response.setPhoneNumber(account.getPhoneNumber());
        return response;
    }

    public Account registerUser(Account account) {
        // Check if the user already exists by email
        Account existingUser = accountRepository.findByEmailAddress(account.getEmailAddress());
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User with this email already exists.");
        }
        String newAccountId = Account.generateId();
        account.setId(newAccountId);
        account.setRole("user");

        // Save the new user
        return accountRepository.save(account);
    }

    public boolean validateLogin(LoginRequest loginRequest) {
        Account account = accountRepository.findByEmailAddress(loginRequest.getEmail());
        // Return false when the email is not found
        return account != null && account.getHashPassword().equals(loginRequest.getPassword()); // Credentials are valid
    }

    public void updateLastLogin(String userEmail) {
        Account account = accountRepository.findByEmailAddress(userEmail);

        if (account != null) {
            account.setLastLogin(LocalDateTime.now());
            accountRepository.save(account);
        }
    }

    public static class UserAlreadyExistsException extends RuntimeException {
        public UserAlreadyExistsException(String message) {
            super(message);
        }
    }
}



