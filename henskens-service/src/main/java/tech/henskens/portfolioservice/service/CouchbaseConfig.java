package tech.henskens.portfolioservice.service;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.mapping.event.ValidatingCouchbaseEventListener;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"tech.henskens.portfolioservice.repository"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.hostname}")
    private String couchbaseHostname;

    @Value("${couchbase.bucketName}")
    private String bucketName;

    @Value("${couchbase.bucketUsername}")
    private String bucketUsername;

    @Value("${couchbase.bucketPassword}")
    private String bucketPassword;

    @Override
    public String getConnectionString() {
        return couchbaseHostname ; // Use the injected value
    }

    @Override
    public String getUserName() {
        return bucketUsername; // Use the injected value
    }

    @Override
    public String getPassword() {
        return bucketPassword; // Use the injected value
    }

    @Override
    public String getBucketName() {
        return bucketName; // Use the injected value
    }

    // Rest of your configuration...

    @Override
    public QueryScanConsistency getDefaultConsistency() {
        return QueryScanConsistency.REQUEST_PLUS;
    }

    @Override
    public String typeKey() {
        return "dataType";
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public ValidatingCouchbaseEventListener validatingCouchbaseEventListener() {
        return new ValidatingCouchbaseEventListener(localValidatorFactoryBean());
    }
}