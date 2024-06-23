package com.metasoft.restyle.platform.remodeling.domain.model.aggregates;

import com.metasoft.restyle.platform.remodeling.domain.model.valueobjects.ProfileId;
import com.metasoft.restyle.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Remodeler extends AuditableAbstractAggregateRoot<Remodeler> {

    @Embedded
    private ProfileId profileId;


}
