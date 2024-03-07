package tech.henskens.userservice.Server.Controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.henskens.userservice.BusinesLogic.Users.UserManager;
import tech.henskens.userservice.dto.User.UserDetailsDto;
import tech.henskens.userservice.model.Users;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserManager userManager;

    @ApiOperation(value = "Get all items", notes = "Returns a list of all items")
    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDetailsDto> getAllUsers(){
        return userManager.getAllUsers();
    }

//    @GetMapping("/account/{emailAddress}")
//    public ResponseEntity<UserByEmail> getAccountByEmail(@PathVariable("emailAddress") String emailAddress) {
//        UserByEmail accountDTO = userManager.findByEmailAddress(emailAddress);
//
//        if (accountDTO != null) {
//            return new ResponseEntity<>(accountDTO, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        if (userManager.validateLogin(loginRequest)) {
//            userManager.updateLastLogin(loginRequest.getEmail());
//            return new ResponseEntity<>("Login successful", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Incorrect credentials", HttpStatus.UNAUTHORIZED);
//        }
//    }

/*    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody Users users) {
        userManager.registerUser(users);
        return ResponseEntity.ok("User registered successfully");
    }*/
}
