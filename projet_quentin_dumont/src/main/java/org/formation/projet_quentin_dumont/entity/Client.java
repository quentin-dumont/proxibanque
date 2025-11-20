package org.formation.projet_quentin_dumont.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="conseiller_id", nullable=false)
    private Conseiller conseiller;

    @OneToMany(mappedBy = "client")
    private Set<Compte> comptes;

    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String telephone;
}
