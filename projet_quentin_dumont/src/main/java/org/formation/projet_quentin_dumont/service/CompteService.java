package org.formation.projet_quentin_dumont.service;

import org.formation.projet_quentin_dumont.entity.Client;
import org.formation.projet_quentin_dumont.entity.Compte;

import java.util.List;
import java.util.Optional;

public interface CompteService {

    Compte createCompte(Compte compte);

    Optional<Compte> getCompte(Long id);

    void virement(Long id, Long id2, Long montant);
}

