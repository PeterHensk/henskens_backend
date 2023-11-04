package tech.henskens.portfolioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import tech.henskens.portfolioservice.service.CouchbaseConfig;

@SpringBootApplication
@Import(CouchbaseConfig.class)
@PropertySource("classpath:application.properties")
public class PortfolioServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioServiceApplication.class, args);
    }

}
