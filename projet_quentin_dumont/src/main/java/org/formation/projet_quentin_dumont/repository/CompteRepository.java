package org.formation.projet_quentin_dumont.repository;

import org.formation.projet_quentin_dumont.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
