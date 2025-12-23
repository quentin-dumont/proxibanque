package org.formation.projet_quentin_dumont.controller;

import jakarta.validation.Valid;
import org.formation.projet_quentin_dumont.dto.ClientDTO;
import org.formation.projet_quentin_dumont.dto.CompteDTO;
import org.formation.projet_quentin_dumont.dto.VirementDTO;
import org.formation.projet_quentin_dumont.entity.Client;
import org.formation.projet_quentin_dumont.entity.Compte;
import org.formation.projet_quentin_dumont.dto.ConseillerDTO;
import org.formation.projet_quentin_dumont.entity.Conseiller;
import org.formation.projet_quentin_dumont.service.ConseillerService;
import org.formation.projet_quentin_dumont.service.ClientService;
import org.formation.projet_quentin_dumont.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProxibanqueController {

    private final ClientService clientService;
    private final CompteService compteService;
    private final ConseillerService conseillerService;

    public ProxibanqueController(ClientService clientService, CompteService compteService, ConseillerService conseillerService) {
        this.clientService = clientService;
        this.compteService = compteService;
        this.conseillerService = conseillerService;
    }

    @GetMapping("/conseillers")
    public List<Conseiller> getAllConseillers() {
        return conseillerService.getAllConseillers();
    }

    @PostMapping("/conseillers")
    public Conseiller createConseiller(@RequestBody @Valid ConseillerDTO conseillerDTO) {
        return conseillerService.createConseiller(conseillerDTO);
    }

    @GetMapping("/conseillers/{id}/clients")
    List<Client> getClientsByConseiller(@PathVariable Long id) {
        return clientService.getClientsByConseiller(id);
    }

    @PostMapping("/conseillers/{id}/clients")
    public ResponseEntity<Client> createClient(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) {
        Client created = clientService.createClient(id, clientDTO);
        if (created == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(created);
    }

    @GetMapping("/clients/{id}")
    Optional<Client> getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PutMapping("/clients/{id}")
    ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        Client updated = clientService.updateClient(id, clientDTO);
        if (updated == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updated);
    }

    @PostMapping("/comptes")
    public Compte createCompte(@RequestBody @Valid CompteDTO compteDTO) {
        return compteService.createCompte(compteDTO);
    }

    @GetMapping("/comptes/{id}")
    Optional<Compte> getCompte(@PathVariable Long id) {
        return compteService.getCompte(id);
    }


    @PostMapping("/virement")
    public ResponseEntity<Void> virement(@RequestBody @Valid VirementDTO virementDTO) {
        compteService.virement(virementDTO);
        return ResponseEntity.status(203).build();
    }

}
