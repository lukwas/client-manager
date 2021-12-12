package pl.lukwas.clientmanager.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SpringBootApplication(scanBasePackages = "pl.lukwas.clientmanager")
@EnableJpaRepositories(basePackages = "pl.lukwas.clientmanager.infrastructure.jpa")
@EntityScan(basePackages = "pl.lukwas.clientmanager.infrastructure.model")
public class ClientManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientManagerApplication.class, args);
    }

    @Bean
    public Validator validator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}