package org.formation.projet_quentin_dumont.controller;

import lombok.RequiredArgsConstructor;
import org.formation.projet_quentin_dumont.entity.Client;
import org.formation.projet_quentin_dumont.entity.Compte;
import org.formation.projet_quentin_dumont.service.ClientService;
import org.formation.projet_quentin_dumont.service.CompteService;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final CompteService compteService;

    @GetMapping("/conseiller{id}/clients")
    List<Client> getClientsByConseiller(@PathVariable Long id) {
        return clientService.getClientsByConseiller(id);
    }

    @GetMapping("/clients/{id}")
    Optional<Client> getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @PostMapping("/clients")
    Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/clients/{id}")
    ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updated = clientService.updateClient(id, client);
        if(updated == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updated);
    }

    @PostMapping("/comptes")
    Compte createCompte(@RequestBody Compte compte) {
        return compteService.createCompte(compte);
    }

    @GetMapping("/comptes/{id}")
    Optional<Compte> getCompte(@PathVariable Long id) {
        return compteService.getCompte(id);
    }

    @PostMapping("/virement/from{compte_id1}/to{compte_id2}/{montant}")
    void virement(@PathVariable Long compte_id1, @PathVariable Long compte_id2, @PathVariable Long montant) {
        return compteService.virement(compte_id1, compte_id2, montant);
    }


}
