package tech.henskens.userservice.Repositories.Users;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.henskens.userservice.model.Users;

import java.util.concurrent.CompletableFuture;

@Component
public class UserQueryManager implements IUserQueryManager {

    @Autowired
    private UserRepository userRepository;

    public CompletableFuture<Users> findByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }
}
