package tech.henskens.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String hashPassword;
    private String phoneNumber;
    private LocalDateTime updated;
    private LocalDateTime lastLogin;
    private String role;
}
