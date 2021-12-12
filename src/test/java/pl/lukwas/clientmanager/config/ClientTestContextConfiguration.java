package pl.lukwas.clientmanager.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TestConfiguration
@ComponentScan(basePackages = "pl.lukwas.clientmanager.domain")
@EnableJpaRepositories(basePackages = "pl.lukwas.clientmanager.infrastructure.jpa")
@EntityScan(basePackages = "pl.lukwas.clientmanager.infrastructure.model")
public class ClientTestContextConfiguration {

}