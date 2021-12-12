package pl.lukwas.clientmanager.webadapter;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukwas.clientmanager.api.ClientService;
import pl.lukwas.clientmanager.api.model.ClientId;
import pl.lukwas.clientmanager.webadapter.request.ClientRequest;
import pl.lukwas.clientmanager.webadapter.response.ClientResponse;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @PostMapping("/create")
    public ResponseEntity<ClientId> create(@RequestBody ClientRequest request) {
        return ResponseEntity.ok(clientService.create(clientMapper.map(request)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable ClientId id, @RequestBody ClientRequest request) {
        clientService.update(id, clientMapper.map(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ClientId id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> fetch(@PathVariable ClientId id) {
        return ResponseEntity.ok(clientMapper.map(clientService.fetch(id)));
    }

}
