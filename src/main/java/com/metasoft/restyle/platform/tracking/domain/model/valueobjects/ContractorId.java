package com.metasoft.restyle.platform.tracking.domain.model.valueobjects;

import java.io.Serializable;

public record ContractorId(Integer contractorId) implements Serializable {

    public Integer getContractorId() {
        return contractorId;
    }

    // validate that the contractorId is equal to or greater than 1
    public ContractorId {
        if (contractorId < 1) {
            throw new IllegalArgumentException("ContractorId must be greater than or equal to 1");
        }
    }
}
