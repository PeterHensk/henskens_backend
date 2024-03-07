package tech.henskens.userservice;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import tech.henskens.userservice.Server.Controllers.UserController;
import tech.henskens.userservice.Repositories.Users.UserRepository;
import tech.henskens.userservice.BusinesLogic.Users.UserManager;
import tech.henskens.userservice.dto.User.UserDetailsDto;
import tech.henskens.userservice.model.Users;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTests {

    @InjectMocks
    private UserManager userManager;

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserController userController;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userManager);
    }

/*    @Test
    public void testCreateUser() {
        //Arrange
        Users users = new Users();
        users.setFirstName("Jan");
        users.setLastName("dingen");
        users.setEmailAddress("jan.dingen@something.com");
        users.setHashPassword("123Password");
        users.setPhoneNumber("014.12.45.45");
        users.setRole("user");

        //Act
        userManager.registerUser(users);

        // Assert
        verify(userRepository, times(1)).save(any(Users.class));
    }*/

    @Test
    public void testGetAllAccounts() {
        // Arrange
        Users users = new Users();
        users.setFirstName("Jan");
        users.setLastName("dingen");
        users.setEmailAddress("jan.dingen@something.com");
        users.setHashPassword("123Password");
        users.setPhoneNumber("014.12.45.45");
        users.setRole("user");

        when(userRepository.findAll()).thenReturn(Arrays.asList(users));

        // Act
        List<UserDetailsDto> userDetailsDtoList = userManager.getAllUsers();

        // Assert
        assertEquals("Jan", users.getFirstName());
        assertEquals("dingen", users.getLastName());
        assertEquals("jan.dingen@something.com", users.getEmailAddress());
        assertEquals("123Password", users.getHashPassword());
        assertEquals("014.12.45.45", users.getPhoneNumber());
        assertEquals("user", users.getRole());

        verify(userRepository, times(1)).findAll();
    }
}
