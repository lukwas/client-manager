package pl.lukwas.clientmanager.webadapter;

import org.springframework.stereotype.Component;
import pl.lukwas.clientmanager.api.model.ClientDto;
import pl.lukwas.clientmanager.api.model.ClientForm;
import pl.lukwas.clientmanager.webadapter.request.ClientRequest;
import pl.lukwas.clientmanager.webadapter.response.ClientResponse;

@Component
public class ClientMapper {
    public ClientForm map(ClientRequest request) {
        return ClientForm.of(request.getName(),
                request.getSurname(),
                request.getEmail(),
                request.getBirthDate());
    }

    public ClientResponse map(ClientDto dto) {
        return ClientResponse.of(dto.getName(),
                dto.getSurname(),
                dto.getEmail(),
                dto.getBirthDate());
    }

}
