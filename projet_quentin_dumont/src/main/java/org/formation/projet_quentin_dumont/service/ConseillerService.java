package org.formation.projet_quentin_dumont.service;

import org.formation.projet_quentin_dumont.dto.ConseillerDTO;
import org.formation.projet_quentin_dumont.entity.Conseiller;

import java.util.List;
import java.util.Optional;

public interface ConseillerService {

    List<Conseiller> getAllConseillers();

    Conseiller createConseiller(ConseillerDTO conseillerDTO);

    Optional<Conseiller> getConseiller(Long id);

}
