package tech.henskens.userservice.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.henskens.userservice.model.Account;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AccountRepository  extends JpaRepository<Account, Long> {
    Account findByEmailAddress(String emailAddress);
}
