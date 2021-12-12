package pl.lukwas.clientmanager.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lukwas.clientmanager.api.ClientService;
import pl.lukwas.clientmanager.api.model.ClientDto;
import pl.lukwas.clientmanager.api.model.ClientForm;
import pl.lukwas.clientmanager.api.model.ClientId;


@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repo;
    private final ClientValidator validator;

    @Override
    @Transactional
    public ClientId create(ClientForm form) {
        validator.validate(form);
        Client client = Client.create(form.getName(),
                form.getSurname(),
                form.getEmail(),
                form.getBirthDate());
        repo.save(client);
        return client.getId();
    }

    @Override
    @Transactional
    public void update(ClientId id, ClientForm form) {
        validator.validate(form);
        Client client = repo.fetch(id)
                .update(form.getName(), form.getSurname(), form.getEmail(), form.getBirthDate());
        repo.save(client);
    }

    @Override
    @Transactional
    public void delete(ClientId id) {
        repo.delete(id);
    }

    @Override
    public ClientDto fetch(ClientId id) {
        return repo.fetch(id).toDto();
    }
}
