package tech.henskens.userservice.Repositories.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import tech.henskens.userservice.model.Users;

import java.util.concurrent.CompletableFuture;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>, IUserRepository {
    @Async
    CompletableFuture<Users> findByEmailAddress(String emailAddress);
}
