package org.formation.projet_quentin_dumont.dto;

public class CompteDTO {

    private Long clientId;
    private Long solde;

    public CompteDTO() {}

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getSolde() {
        return solde;
    }

    public void setSolde(Long solde) {
        this.solde = solde;
    }
}
