package tech.henskens.portfolioservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Account {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    @Id
    private String id;

    @Field
    @NotNull
    private String firstName;

    @Field
    @NotNull
    private String lastName;

    @Field
    private String emailAddress;

    @Field
    private String hashPassword;

    @Field
    private String phoneNumber;

    @Field
    private String role;

    @Field
    private LocalDateTime updated;

    @Field
    private LocalDateTime lastLogin;
}
