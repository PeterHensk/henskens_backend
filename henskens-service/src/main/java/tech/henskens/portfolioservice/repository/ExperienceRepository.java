package tech.henskens.portfolioservice.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.henskens.portfolioservice.model.Experience;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@Scope("portfolio")
@Collection("experience")
public interface ExperienceRepository extends CrudRepository<Experience, Long> {

    List<Experience> findByCompany(String company);

    Optional<Experience> findById(String id);
}
