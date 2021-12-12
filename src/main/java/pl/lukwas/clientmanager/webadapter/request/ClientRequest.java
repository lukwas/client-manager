package pl.lukwas.clientmanager.webadapter.request;

import lombok.Value;

import java.time.LocalDate;

@Value(staticConstructor = "of")
public class ClientRequest {

    String name;

    String surname;

    String email;

    LocalDate birthDate;
}
