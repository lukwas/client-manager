package pl.lukwas.clientmanager.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ClockProvider;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ClientValidator {

    private final ClockProvider clockProvider;

    public void validate(Object obj) {
        //TODO move to one time initialization
        ValidatorFactory validatorFactory = Validation.byDefaultProvider()
                .configure()
                .clockProvider(clockProvider)
                .buildValidatorFactory();

        Set<ConstraintViolation<Object>> result = validatorFactory.getValidator().validate(obj);
        if (!result.isEmpty()) {
            throw new ValidationException(result.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";")));
        }
    }

}
