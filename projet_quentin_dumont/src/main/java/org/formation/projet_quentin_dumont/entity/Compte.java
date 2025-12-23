package org.formation.projet_quentin_dumont.entity;

import jakarta.persistence.*;

@Entity
public class Compte {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    private Long solde;

    public Compte() {
    }

    public Long getId() {
        return this.id;
    }

    public Client getClient() {
        return this.client;
    }

    public Long getSolde() {
        return this.solde;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSolde(Long solde) {
        this.solde = solde;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Compte)) return false;
        final Compte other = (Compte) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$client = this.getClient();
        final Object other$client = other.getClient();
        if (this$client == null ? other$client != null : !this$client.equals(other$client)) return false;
        final Object this$solde = this.getSolde();
        final Object other$solde = other.getSolde();
        if (this$solde == null ? other$solde != null : !this$solde.equals(other$solde)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Compte;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $client = this.getClient();
        result = result * PRIME + ($client == null ? 43 : $client.hashCode());
        final Object $solde = this.getSolde();
        result = result * PRIME + ($solde == null ? 43 : $solde.hashCode());
        return result;
    }

    public String toString() {
        return "Compte(id=" + this.getId() + ", client=" + this.getClient() + ", solde=" + this.getSolde() + ")";
    }
}
