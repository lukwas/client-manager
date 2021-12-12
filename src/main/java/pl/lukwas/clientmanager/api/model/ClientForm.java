package pl.lukwas.clientmanager.api.model;

import lombok.Value;
import pl.lukwas.clientmanager.api.model.validation.BirthDateConstraint;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value(staticConstructor = "of")
public class ClientForm {

    String name;

    String surname;

    //TODO dodac walidacej poprawności emaila
    @NotNull(message = "Email should not be null")
    String email;

    @BirthDateConstraint
    LocalDate birthDate;
}
