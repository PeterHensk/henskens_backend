package tech.henskens.portfolioservice.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.henskens.portfolioservice.model.Portfolio;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@Scope("portfolio")
@Collection("portfolio")
public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {

    List<Portfolio> findByApplicationName(String applicationName);


    Optional<Portfolio> findById(String id);
}
