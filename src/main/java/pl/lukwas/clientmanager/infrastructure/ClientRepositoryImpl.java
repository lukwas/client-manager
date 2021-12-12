package pl.lukwas.clientmanager.infrastructure;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.lukwas.clientmanager.api.ClientNotFoundException;
import pl.lukwas.clientmanager.api.model.ClientId;
import pl.lukwas.clientmanager.domain.Client;
import pl.lukwas.clientmanager.domain.ClientRepository;
import pl.lukwas.clientmanager.infrastructure.jpa.JpaClientRepository;
import pl.lukwas.clientmanager.infrastructure.model.ClientMappingMapper;

@Slf4j
@Repository
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final JpaClientRepository repo;
    private final ClientMappingMapper mapper;

    @Override
    public Client fetch(ClientId id) {
        log.info("fetch {}", id);
        return repo.findById(id.getValue()).map(mapper::map)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @Override
    public void save(Client client) {
        log.info("save {}", client.getId());
        repo.save(mapper.map(client));
    }

    @Override
    public void delete(ClientId id) {
        log.info("delete {}", id);
        repo.deleteById(id.getValue());
    }
}
