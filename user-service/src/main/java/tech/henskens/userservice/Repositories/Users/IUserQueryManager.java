package tech.henskens.userservice.Repositories.Users;

import tech.henskens.userservice.model.Users;

import java.util.concurrent.CompletableFuture;

public interface IUserQueryManager {
    CompletableFuture<Users> findByEmailAddress(String emailAddress);
}
