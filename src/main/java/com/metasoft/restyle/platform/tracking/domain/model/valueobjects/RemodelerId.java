package com.metasoft.restyle.platform.tracking.domain.model.valueobjects;

import java.io.Serializable;

public record RemodelerId(Integer remodelerId) implements Serializable {
    public Integer getRemodelerId() {
        return remodelerId;
    }
    public RemodelerId{
        if (remodelerId < 1){
            throw new IllegalArgumentException("RemodelerId must be greater than 0");
        }
    }
}
