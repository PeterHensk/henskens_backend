package tech.henskens.portfolioservice.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.henskens.portfolioservice.model.Account;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@Scope("portfolio")
@Collection("account")
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByEmailAddress(String emailAddress);

    List<Account> findByLastName(String lastName);

    Optional<Account> findById(String id);
}
