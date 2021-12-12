package pl.lukwas.clientmanager.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.lukwas.clientmanager.api.ClientService;
import pl.lukwas.clientmanager.api.model.ClientForm;
import pl.lukwas.clientmanager.api.model.ClientId;
import pl.lukwas.clientmanager.config.AbstractIntegrationTest;
import pl.lukwas.clientmanager.config.TestClockProvider;

import javax.validation.ValidationException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class ClientServiceTest extends AbstractIntegrationTest {

    @Autowired
    private ClientService clientService;

    @Autowired
    private TestClockProvider testClockProvider;

    //TODO przemyśleć dodanie czyszczenie bazy po przypadku testowym bo moze pojawić się konflikt na dodaniu kolejnego klienta z tym samym mailem
    // lub generować zawsze nowe maile

    @Test
    public void shouldVerifyAddingClient() {
        testClockProvider.setClock(LocalDateTime.of(2021, 1, 1, 0, 0));

        assertThatNoException()
                .isThrownBy(() ->
                        clientService.create(ClientForm.of("x", "y", "e1", LocalDate.of(2000, 1, 1))));
    }

    @Test
    public void shouldVerifyAddingClientWhenAgeIsTooSmallFails() {
        testClockProvider.setClock(LocalDateTime.of(2001, 1, 1, 0, 0));

        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() ->
                        clientService.create(ClientForm.of("x", "y", "e2", LocalDate.of(2000, 1, 1))));
    }

    @Test
    public void shouldVerifyUpdatingClientWhenAgeIsTooSmallFails() {
        testClockProvider.setClock(LocalDateTime.of(2021, 1, 1, 0, 0));

        ClientId clientId = clientService.create(ClientForm.of("x", "y", "e3", LocalDate.of(2000, 1, 1)));

        assertThatExceptionOfType(ValidationException.class)
                .isThrownBy(() -> clientService.update(
                        clientId,
                        ClientForm.of("x", "y", "e3", LocalDate.of(2011, 1, 1))));
    }

}