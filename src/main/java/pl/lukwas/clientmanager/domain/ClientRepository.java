package pl.lukwas.clientmanager.domain;

import pl.lukwas.clientmanager.api.model.ClientId;

public interface ClientRepository {
    Client fetch(ClientId id);

    void save(Client client);

    void delete(ClientId id);
}
