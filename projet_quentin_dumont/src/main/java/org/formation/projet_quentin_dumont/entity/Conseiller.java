package org.formation.projet_quentin_dumont.entity;

import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Conseiller {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "conseiller")
    private Set<Client> clients;

    private String nom;
    private String prenom;
}

