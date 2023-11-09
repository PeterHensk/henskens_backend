package tech.henskens.userservice;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tech.henskens.userservice.Controller.AccountController;
import tech.henskens.userservice.Repository.AccountRepository;
import tech.henskens.userservice.Service.AccountService;
import tech.henskens.userservice.dto.AccountByEmail;
import tech.henskens.userservice.dto.AccountResponse;
import tech.henskens.userservice.dto.LoginRequest;
import tech.henskens.userservice.model.Account;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTests {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private AccountController accountController;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        accountController = new AccountController(accountService);
    }

    @Test
    public void testCreateUser() {
        //Arrange
        Account account = new Account();
        account.setFirstName("Jan");
        account.setLastName("dingen");
        account.setEmailAddress("jan.dingen@something.com");
        account.setHashPassword("123Password");
        account.setPhoneNumber("014.12.45.45");
        account.setRole("user");

        //Act
        accountService.registerUser(account);

        // Assert
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    public void testGetAllAccounts() {
        // Arrange
        Account account = new Account();
        account.setFirstName("Jan");
        account.setLastName("dingen");
        account.setEmailAddress("jan.dingen@something.com");
        account.setHashPassword("123Password");
        account.setPhoneNumber("014.12.45.45");
        account.setRole("user");

        when(accountRepository.findAll()).thenReturn(Arrays.asList(account));

        // Act
        List<AccountResponse> accountResponseList = accountService.getAllAccounts();

        // Assert
        assertEquals("Jan", account.getFirstName());
        assertEquals("dingen", account.getLastName());
        assertEquals("jan.dingen@something.com", account.getEmailAddress());
        assertEquals("123Password", account.getHashPassword());
        assertEquals("014.12.45.45", account.getPhoneNumber());
        assertEquals("user", account.getRole());

        verify(accountRepository, times(1)).findAll();
    }

    @Test
    public void testGetAccountByEmailaddress() {
        // Arrange
        Account account = new Account();
        account.setFirstName("Jan");
        account.setLastName("dingen");
        account.setEmailAddress("jan.dingen@something.com");
        account.setHashPassword("123Password");
        account.setPhoneNumber("014.12.45.45");
        account.setRole("user");

        Mockito.when(accountRepository.findByEmailAddress("jan.dingen@something.com")).thenReturn(account);

        // Act
        AccountByEmail accountResponse = accountService.findByEmailAddress("jan.dingen@something.com");

        // Assert
        assertEquals("Jan", account.getFirstName());
        assertEquals("dingen", account.getLastName());
        assertEquals("jan.dingen@something.com", account.getEmailAddress());
        assertEquals("123Password", account.getHashPassword());
        assertEquals("014.12.45.45", account.getPhoneNumber());
        assertEquals("user", account.getRole());

        Mockito.verify(accountRepository, Mockito.times(1)).findByEmailAddress("jan.dingen@something.com");
    }

//    @Test
//    public void testLogin_Success() {
//        // Arrange
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setEmail("valid@example.com");
//        loginRequest.setPassword("validPassword");
//
//        // Create a mock Account object
//        Account validAccount = new Account();
//        validAccount.setEmailAddress("valid@example.com");
//        validAccount.setHashPassword("validPassword");
//
//        Mockito.when(accountRepository.findByEmailAddress("valid@example.com")).thenReturn(validAccount);
//        Mockito.when(accountService.validateLogin(loginRequest)).thenReturn(true);
//
//        // Act
//        AccountController accountController = new AccountController(accountService);
//        ResponseEntity<String> responseEntity = accountController.login(loginRequest);
//
//        // Assert
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Login successful", responseEntity.getBody());
//
//        // Verify that the updateLastLogin method was called once
//        Mockito.verify(accountService, Mockito.times(1)).updateLastLogin(loginRequest.getEmail());
//    }

//    @Test
//    public void testLogin_Failure() {
//        // Arrange
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setEmail("invalid@example.com");
//        loginRequest.setPassword("invalidPassword");
//
//        Mockito.when(accountService.validateLogin(loginRequest)).thenReturn(false);
//
//        // Act
//        AccountController accountController = new AccountController(accountService);
//        ResponseEntity<String> responseEntity = accountController.login(loginRequest);
//
//        // Assert
//        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
//        assertEquals("Incorrect credentials", responseEntity.getBody());
//
//        // Verify that the updateLastLogin method was not called
//        Mockito.verify(accountService, Mockito.never()).updateLastLogin(Mockito.anyString());
//    }
}
