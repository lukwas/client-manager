package pl.lukwas.clientmanager.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukwas.clientmanager.infrastructure.model.ClientMapping;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientMapping, String> {
}
