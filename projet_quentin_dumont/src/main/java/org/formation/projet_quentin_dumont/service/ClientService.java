package org.formation.projet_quentin_dumont.service;

import org.formation.projet_quentin_dumont.entity.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> getClientsByConseiller(Long idConseiller);

    Client createClient(Client client);

    Optional<Client> getClient(Long id);

    Client updateClient(Long id, Client client);
}

