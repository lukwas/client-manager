package pl.lukwas.clientmanager.infrastructure.model;

import org.springframework.stereotype.Component;
import pl.lukwas.clientmanager.api.model.ClientId;
import pl.lukwas.clientmanager.domain.Client;

@Component
public class ClientMappingMapper {
    public Client map(ClientMapping mapping) {
        return Client.rehydrate(
                ClientId.of(mapping.getId()),
                mapping.getName(),
                mapping.getSurname(),
                mapping.getEmail(),
                mapping.getBirthDate());
    }

    public ClientMapping map(Client client) {
        return ClientMapping.of(
                client.getId().getValue(),
                client.getName(),
                client.getSurname(),
                client.getEmail(),
                client.getBirthDate());
    }

}
