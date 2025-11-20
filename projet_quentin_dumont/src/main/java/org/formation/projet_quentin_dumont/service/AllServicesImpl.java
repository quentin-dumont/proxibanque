package org.formation.projet_quentin_dumont.service;

import lombok.RequiredArgsConstructor;

import org.formation.projet_quentin_dumont.entity.Client;
import org.formation.projet_quentin_dumont.entity.Compte;
import org.formation.projet_quentin_dumont.repository.ClientRepository;
import org.formation.projet_quentin_dumont.repository.CompteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AllServicesImpl implements ClientService, CompteService {

    private final ClientRepository clientRepository;
    private final CompteRepository compteRepository;

    @Override
    public List<Client> getClientsByConseiller(Long idConseiller) {
        return clientRepository.findByConseiller(idConseiller);
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        if (!clientRepository.existsById(id)) {
            return null;
        }
        return clientRepository.save(client);
    }

    @Override
    public Compte createCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public Optional<Compte> getCompte(Long id) {
        return compteRepository.findById(id);
    }

    @Override
    public Compte virement(Long compte_id1, Long compte_id2, Long montant) {

        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant du virement doit être positif.");
        }

        Compte compteSource = compteRepository.findById(compte_id1)
                .orElseThrow(() -> new IllegalArgumentException("Compte source introuvable"));

        Compte compteDest = compteRepository.findById(compte_id2)
                .orElseThrow(() -> new IllegalArgumentException("Compte destinataire introuvable"));

        if (compteSource.getSolde() < montant) {
            throw new IllegalArgumentException("Solde insuffisant pour effectuer le virement.");
        }

        compteSource.setSolde(compteSource.getSolde() - montant);
        compteDest.setSolde(compteDest.getSolde() + montant);

        compteRepository.save(compteSource);
        compteRepository.save(compteDest);

        return null;
    }
}
