package org.formation.projet_quentin_dumont.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Conseiller {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "conseiller")
    private Set<Client> clients = new HashSet<Client>();

    private String nom;
    private String prenom;

    public Conseiller() {
    }

    public Long getId() {
        return this.id;
    }

    public Set<Client> getClients() {
        return this.clients;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Conseiller)) return false;
        final Conseiller other = (Conseiller) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$clients = this.getClients();
        final Object other$clients = other.getClients();
        if (this$clients == null ? other$clients != null : !this$clients.equals(other$clients)) return false;
        final Object this$nom = this.getNom();
        final Object other$nom = other.getNom();
        if (this$nom == null ? other$nom != null : !this$nom.equals(other$nom)) return false;
        final Object this$prenom = this.getPrenom();
        final Object other$prenom = other.getPrenom();
        if (this$prenom == null ? other$prenom != null : !this$prenom.equals(other$prenom)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Conseiller;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $clients = this.getClients();
        result = result * PRIME + ($clients == null ? 43 : $clients.hashCode());
        final Object $nom = this.getNom();
        result = result * PRIME + ($nom == null ? 43 : $nom.hashCode());
        final Object $prenom = this.getPrenom();
        result = result * PRIME + ($prenom == null ? 43 : $prenom.hashCode());
        return result;
    }

    public String toString() {
        return "Conseiller(id=" + this.getId() + ", clients=" + this.getClients() + ", nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ")";
    }
}

