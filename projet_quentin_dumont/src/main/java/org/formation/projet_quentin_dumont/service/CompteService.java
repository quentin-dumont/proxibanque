package org.formation.projet_quentin_dumont.service;

import org.formation.projet_quentin_dumont.dto.CompteDTO;
import org.formation.projet_quentin_dumont.dto.VirementDTO;
import org.formation.projet_quentin_dumont.entity.Client;
import org.formation.projet_quentin_dumont.entity.Compte;

import java.util.List;
import java.util.Optional;

public interface CompteService {

    Compte createCompte(CompteDTO compteDTO);

    Optional<Compte> getCompte(Long id);

    void virement(VirementDTO virementDTO);
}

