package pl.lukwas.clientmanager.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;
import pl.lukwas.clientmanager.api.model.ClientDto;
import pl.lukwas.clientmanager.api.model.ClientId;

import java.time.LocalDate;
import java.util.UUID;

@Value
@AllArgsConstructor(staticName = "of", access = AccessLevel.PRIVATE)
public class Client {

    ClientId id;

    String name;

    String surname;

    String email;

    LocalDate birthDate;

    public static Client create(String name, String surname, String email, LocalDate birthDate) {
        return Client.of(ClientId.of(UUID.randomUUID().toString()),
                name,
                surname,
                email,
                birthDate);
    }

    public static Client rehydrate(ClientId id, String name, String surname, String email, LocalDate birthDate) {
        return Client.of(id, name, surname, email, birthDate);
    }

    public Client update(String name, String surname, String email, LocalDate birthDate) {
        return Client.of(this.getId(),
                name,
                surname,
                email,
                birthDate);
    }

    public ClientDto toDto() {
        return ClientDto.of(this.getId(),
                this.getName(),
                this.getSurname(),
                this.getEmail(),
                this.getBirthDate());
    }
}
