package org.formation.projet_quentin_dumont.dto;

public class ClientDTO {

    private Long conseillerId;
    private String nom;
    private String prenom;
    private String streetNumberAndName;
    private Integer codePostal;
    private String ville;
    private String telephone;

    public ClientDTO() {}

    public Long getConseillerId() {
        return conseillerId;
    }

    public void setConseillerId(Long conseillerId) {
        this.conseillerId = conseillerId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getStreetNumberAndName() {
        return streetNumberAndName;
    }

    public void setStreetNumberAndName(String streetNumberAndName) {
        this.streetNumberAndName = streetNumberAndName;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
