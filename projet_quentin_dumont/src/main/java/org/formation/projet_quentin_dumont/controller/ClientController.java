package org.formation.projet_quentin_dumont.controller;

import lombok.RequiredArgsConstructor;
import org.formation.projet_quentin_dumont.entity.Client;
import org.formation.projet_quentin_dumont.service.ClientService;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping("/conseiller{id}/clients")
    List<Client> getClientsByConseiller(@PathVariable Long id) {
        return service.getClientsByConseiller(id);
    }

    @GetMapping("/clients/{id}")
    Optional<Client> getClient(@PathVariable Long id) {
        return service.getClient(id);
    }

    @PostMapping("/clients")
    Client createClient(@RequestBody Client client) {
        return service.createClient(client);
    }

    @PutMapping("/clients/{id}")
    ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updated = service.updateClient(id, client);
        if(updated == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updated);
    }

}
