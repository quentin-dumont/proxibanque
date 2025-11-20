package org.formation.projet_quentin_dumont.repository;

import org.formation.projet_quentin_dumont.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByConseiller(Long conseiller);
}
