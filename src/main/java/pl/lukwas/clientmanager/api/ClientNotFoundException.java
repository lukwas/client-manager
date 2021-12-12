package pl.lukwas.clientmanager.api;

import pl.lukwas.clientmanager.api.model.ClientId;

import java.text.MessageFormat;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(ClientId id) {
        super(MessageFormat.format("Client with id {0} not found", id));
    }
}
