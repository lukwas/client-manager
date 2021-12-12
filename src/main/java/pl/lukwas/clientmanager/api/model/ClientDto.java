package pl.lukwas.clientmanager.api.model;

import lombok.Value;

import java.time.LocalDate;

@Value(staticConstructor = "of")
public class ClientDto {

    ClientId id;

    String name;

    String surname;

    String email;

    LocalDate birthDate;
}
