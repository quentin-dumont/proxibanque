package org.formation.projet_quentin_dumont.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Compte {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    private String nom;
    private String prenom;
}
