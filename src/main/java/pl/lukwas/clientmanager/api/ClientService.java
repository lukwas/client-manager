package pl.lukwas.clientmanager.api;

import pl.lukwas.clientmanager.api.model.ClientDto;
import pl.lukwas.clientmanager.api.model.ClientForm;
import pl.lukwas.clientmanager.api.model.ClientId;

public interface ClientService {
    ClientId create(ClientForm form);

    void update(ClientId id, ClientForm form);

    void delete(ClientId id);

    ClientDto fetch(ClientId id);
}
