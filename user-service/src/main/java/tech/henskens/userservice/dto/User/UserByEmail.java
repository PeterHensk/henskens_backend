package tech.henskens.userservice.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserByEmail {
    private Long id;
    private String emailAddress;
    private String firstName;
}
