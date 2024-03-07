package tech.henskens.userservice.BusinesLogic.Users;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;
import tech.henskens.userservice.Repositories.Users.UserRepository;
import tech.henskens.userservice.dto.User.UserByEmail;
import tech.henskens.userservice.dto.User.UserDetailsDto;
import tech.henskens.userservice.model.Users;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager {
    private final UserRepository userRepository;

    public List<UserDetailsDto> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    private UserDetailsDto convertToUserDto(Users users) {
        UserDetailsDto response = new UserDetailsDto();
        response.setFirstName(users.getFirstName());
        response.setLastName(users.getLastName());
        response.setEmailAddress(users.getEmailAddress());
        response.setHashPassword(users.getHashPassword());
        response.setPhoneNumber(users.getPhoneNumber());
        response.setLastLogin(users.getLastLogin());
        response.setRole(users.getRole());
        return response;

/*    public void registerUser(Users users) {
        CompletableFuture<Users> existingUser = userRepository.findByEmailAddress(users.getEmailAddress());
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User with this email already exists.");
        }
        users.setRole("user");
        users.setUpdated(LocalDateTime.now());

        // Save the new user
        userRepository.save(users);
    }*/

//    public boolean validateLogin(LoginRequest loginRequest) {
//        CompletableFuture<Users> users = userRepository.findByEmailAddress(loginRequest.getEmail());
//        // Return false when the email is not found
//        // Credentials are not valid
//        return users != null && users.getHashPassword().equals(loginRequest.getPassword()); // Credentials are valid
//    }
//
//    public void updateLastLogin(String userEmail) {
//        CompletableFuture<Users> users = userRepository.findByEmailAddress(userEmail);
//
//        if (users != null) {
//            users.setLastLogin(LocalDateTime.now());
//            userRepository.save(users);
//        }
//    }

//    public UserByEmail findByEmailAddress(String emailAddress){
//        Users users = userRepository.findByEmailAddress(emailAddress);
//        if (users != null) {
//            // Convert Account entity to DTO
//            return convertToDTO(users);
//        } else {
//            return null;
//        }
//    }

/*    private UserByEmail convertToDTO(Users users) {
        UserByEmail dto = new UserByEmail();
        dto.setId(users.getId());
        dto.setEmailAddress(users.getEmailAddress());
        dto.setFirstName(users.getFirstName());
        return dto;
    }

    public static class UserAlreadyExistsException extends RuntimeException {
        public UserAlreadyExistsException(String message) {
            super(message);
        }
    }*/
    }
}
