package org.formation.projet_quentin_dumont.service;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.formation.projet_quentin_dumont.entity.Client;
import org.formation.projet_quentin_dumont.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Override
    public List<Client> getClientsByConseiller(Long idConseiller) {
        return repository.findByConseiller(idConseiller);
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return repository.findById(id);
    }

    @Override
    public Client createClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        if (!repository.existsById(id)) {
            return null;
        }
        return repository.save(client);
    }
}
