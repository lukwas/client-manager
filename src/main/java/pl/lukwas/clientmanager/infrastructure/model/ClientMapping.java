package pl.lukwas.clientmanager.infrastructure.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor(staticName = "of", access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "client", uniqueConstraints = {
        @UniqueConstraint(name = "UC_CLIENT_EMAIL", columnNames = {"email"})
})
public class ClientMapping {

    @Id
    @Column(length = 36)
//    @Convert(converter = ClientIdConverter.class)
    //TODO dobrze jak by tu jako id było ClientId ale coś nie działa i zabrakło czasu na dokończenie
    private String id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String surname;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate birthDate;
}
