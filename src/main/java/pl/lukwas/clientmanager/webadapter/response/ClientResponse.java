package pl.lukwas.clientmanager.webadapter.response;

import lombok.Value;

import java.time.LocalDate;

@Value(staticConstructor = "of")
public class ClientResponse {

    String name;

    String surname;

    String email;

    LocalDate birthDate;

}
