package org.formation.projet_quentin_dumont.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conseiller_id", nullable = false)
    private Conseiller conseiller;

    @OneToMany(mappedBy = "client")
    private Set<Compte> comptes = new HashSet<Compte>();

    private String nom;
    private String prenom;
    private String streetNumberAndName;
    private Integer codePostal;
    private String ville;
    private String telephone;

    public Client() {
    }

    public Long getId() {
        return this.id;
    }

    public Conseiller getConseiller() {
        return this.conseiller;
    }

    public Set<Compte> getComptes() {
        return this.comptes;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getStreetNumberAndName() {
        return this.streetNumberAndName;
    }

    public Integer getCodePostal() {
        return this.codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setStreetNumberAndName(String streetNumberAndName) {
        this.streetNumberAndName = streetNumberAndName;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Client)) return false;
        final Client other = (Client) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$conseiller = this.getConseiller();
        final Object other$conseiller = other.getConseiller();
        if (this$conseiller == null ? other$conseiller != null : !this$conseiller.equals(other$conseiller))
            return false;
        final Object this$comptes = this.getComptes();
        final Object other$comptes = other.getComptes();
        if (this$comptes == null ? other$comptes != null : !this$comptes.equals(other$comptes)) return false;
        final Object this$nom = this.getNom();
        final Object other$nom = other.getNom();
        if (this$nom == null ? other$nom != null : !this$nom.equals(other$nom)) return false;
        final Object this$prenom = this.getPrenom();
        final Object other$prenom = other.getPrenom();
        if (this$prenom == null ? other$prenom != null : !this$prenom.equals(other$prenom)) return false;
        final Object this$streetNumberAndName = this.getStreetNumberAndName();
        final Object other$streetNumberAndName = other.getStreetNumberAndName();
        if (this$streetNumberAndName == null ? other$streetNumberAndName != null : !this$streetNumberAndName.equals(other$streetNumberAndName)) return false;
        final Object this$codePostal = this.getCodePostal();
        final Object other$codePostal = other.getCodePostal();
        if (this$codePostal == null ? other$codePostal != null : !this$codePostal.equals(other$codePostal))
            return false;
        final Object this$ville = this.getVille();
        final Object other$ville = other.getVille();
        if (this$ville == null ? other$ville != null : !this$ville.equals(other$ville)) return false;
        final Object this$telephone = this.getTelephone();
        final Object other$telephone = other.getTelephone();
        if (this$telephone == null ? other$telephone != null : !this$telephone.equals(other$telephone)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Client;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $conseiller = this.getConseiller();
        result = result * PRIME + ($conseiller == null ? 43 : $conseiller.hashCode());
        final Object $comptes = this.getComptes();
        result = result * PRIME + ($comptes == null ? 43 : $comptes.hashCode());
        final Object $nom = this.getNom();
        result = result * PRIME + ($nom == null ? 43 : $nom.hashCode());
        final Object $prenom = this.getPrenom();
        result = result * PRIME + ($prenom == null ? 43 : $prenom.hashCode());
        final Object $streetNumberAndName = this.getStreetNumberAndName();
        result = result * PRIME + ($streetNumberAndName == null ? 43 : $streetNumberAndName.hashCode());
        final Object $codePostal = this.getCodePostal();
        result = result * PRIME + ($codePostal == null ? 43 : $codePostal.hashCode());
        final Object $ville = this.getVille();
        result = result * PRIME + ($ville == null ? 43 : $ville.hashCode());
        final Object $telephone = this.getTelephone();
        result = result * PRIME + ($telephone == null ? 43 : $telephone.hashCode());
        return result;
    }

    public String toString() {
        return "Client(id=" + this.getId() + ", conseiller=" + this.getConseiller() + ", comptes=" + this.getComptes() + ", nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", streetNumberAndName=" + this.getStreetNumberAndName() + ", codePostal=" + this.getCodePostal() + ", ville=" + this.getVille() + ", telephone=" + this.getTelephone() + ")";
    }
}
