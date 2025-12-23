package org.formation.projet_quentin_dumont.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VirementDTO {

    @NotNull
    private Long compteSourceId;

    @NotNull
    private Long compteDestinationId;

    @NotNull
    @Positive(message = "Le montant du virement doit être strictement positif.")
    private Long montant;

    public VirementDTO() {}

    public VirementDTO(Long compteSourceId, Long compteDestinationId, Long montant) {
        this.compteSourceId = compteSourceId;
        this.compteDestinationId = compteDestinationId;
        this.montant = montant;
    }

    public Long getCompteSourceId() {
        return compteSourceId;
    }

    public void setCompteSourceId(Long compteSourceId) {
        this.compteSourceId = compteSourceId;
    }

    public Long getCompteDestinationId() {
        return compteDestinationId;
    }

    public void setCompteDestinationId(Long compteDestinationId) {
        this.compteDestinationId = compteDestinationId;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }
}