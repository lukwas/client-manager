package pl.lukwas.clientmanager.infrastructure.converter;

import pl.lukwas.clientmanager.api.model.ClientId;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//TODO chwilowo zbedne bo id jest zapisane jako string
@Converter
public class ClientIdConverter implements AttributeConverter<ClientId, String> {

    @Override
    public String convertToDatabaseColumn(ClientId clientId) {
        return clientId.getValue();
    }

    @Override
    public ClientId convertToEntityAttribute(String val) {
        return ClientId.of(val);
    }
}
