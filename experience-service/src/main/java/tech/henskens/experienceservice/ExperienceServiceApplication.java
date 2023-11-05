package tech.henskens.experienceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ExperienceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperienceServiceApplication.class, args);
    }

}
