package pl.lukwas.clientmanager.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Schema(type = "string")
@Value(staticConstructor = "of")
public class ClientId {
    String value;
}
