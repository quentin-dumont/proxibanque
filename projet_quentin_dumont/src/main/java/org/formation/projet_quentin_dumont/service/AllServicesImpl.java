package org.formation.projet_quentin_dumont.service;

import org.formation.projet_quentin_dumont.dto.ClientDTO;
import org.formation.projet_quentin_dumont.dto.CompteDTO;
import org.formation.projet_quentin_dumont.dto.ConseillerDTO;
import org.formation.projet_quentin_dumont.entity.Client;
import org.formation.projet_quentin_dumont.entity.Compte;
import org.formation.projet_quentin_dumont.dto.VirementDTO;
import org.formation.projet_quentin_dumont.entity.Conseiller;
import org.formation.projet_quentin_dumont.repository.ClientRepository;
import org.formation.projet_quentin_dumont.repository.CompteRepository;
import org.formation.projet_quentin_dumont.repository.ConseillerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllServicesImpl implements ClientService, CompteService, ConseillerService {

    private final ClientRepository clientRepository;
    private final CompteRepository compteRepository;
    private final ConseillerRepository conseillerRepository;

    public AllServicesImpl(ClientRepository clientRepository, CompteRepository compteRepository, ConseillerRepository conseillerRepository) {
        this.clientRepository = clientRepository;
        this.compteRepository = compteRepository;
        this.conseillerRepository = conseillerRepository;
    }

    @Override
    public List<Client> getClientsByConseiller(Long idConseiller) {
        return clientRepository.findByConseillerId(idConseiller);
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client createClient(Long conseillerId, ClientDTO clientDTO) {
        if (!conseillerRepository.existsById(conseillerId)) {
            return null;
        }
        Conseiller conseiller = conseillerRepository.findById(conseillerId).get();

        Client client = new Client();
        client.setNom(clientDTO.getNom());
        client.setPrenom(clientDTO.getPrenom());
        client.setStreetNumberAndName(clientDTO.getStreetNumberAndName());
        client.setCodePostal(clientDTO.getCodePostal());
        client.setVille(clientDTO.getVille());
        client.setTelephone(clientDTO.getTelephone());
        client.setConseiller(conseiller);

        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, ClientDTO clientDTO) {
        if (!clientRepository.existsById(id)) {
            return null;
        }
        // Retrieve existing client, update fields and save
        Optional<Client> opt = clientRepository.findById(id);
        if (opt.isEmpty()) {
            return null;
        }
        Client existing = opt.get();
        existing.setNom(clientDTO.getNom());
        existing.setPrenom(clientDTO.getPrenom());
        existing.setStreetNumberAndName(clientDTO.getStreetNumberAndName());
        existing.setCodePostal(clientDTO.getCodePostal());
        existing.setVille(clientDTO.getVille());
        existing.setTelephone(clientDTO.getTelephone());
        return clientRepository.save(existing);
    }

    @Override
    public Compte createCompte(CompteDTO compteDTO) {
        Compte compte = new Compte();
        compte.setSolde(compteDTO.getSolde());
        Client client = new Client();
        client.setId(compteDTO.getClientId());
        compte.setClient(client);
        return compteRepository.save(compte);
    }

    @Override
    public Optional<Compte> getCompte(Long id) {
        return compteRepository.findById(id);
    }

    @Override
    public List<Conseiller> getAllConseillers() {
        return conseillerRepository.findAll();
    }

    @Override
    public Conseiller createConseiller(ConseillerDTO conseillerDTO) {
        Conseiller conseiller = new Conseiller();
        conseiller.setNom(conseillerDTO.getNom());
        conseiller.setPrenom(conseillerDTO.getPrenom());
        return conseillerRepository.save(conseiller);
    }

    @Override
    public Optional<Conseiller> getConseiller(Long id) {
        return conseillerRepository.findById(id);
    }

    @Override
    public void virement(VirementDTO virementDTO) {

        Long compte_id1 = virementDTO.getCompteSourceId();
        Long compte_id2 = virementDTO.getCompteDestinationId();
        Long montant = virementDTO.getMontant();

        if (montant == null || montant <= 0) {
            throw new IllegalArgumentException("Le montant du virement doit être positif.");
        }

        Compte compteSource = compteRepository.findById(compte_id1)
                .orElseThrow(() -> new IllegalArgumentException("Compte source introuvable"));

        Compte compteDest = compteRepository.findById(compte_id2)
                .orElseThrow(() -> new IllegalArgumentException("Compte destinataire introuvable"));

        if (compteSource.getSolde() == null || compteSource.getSolde() < montant) {
            throw new IllegalArgumentException("Solde insuffisant pour effectuer le virement.");
        }

        compteSource.setSolde(compteSource.getSolde() - montant);
        compteDest.setSolde((compteDest.getSolde() == null ? 0L : compteDest.getSolde()) + montant);

        compteRepository.save(compteSource);
        compteRepository.save(compteDest);
    }
}
