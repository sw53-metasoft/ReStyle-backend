package com.metasoft.restyle.platform.rating.domain.model.queries;

import com.metasoft.restyle.platform.rating.domain.model.valueobjects.ContractorId;
import com.metasoft.restyle.platform.rating.domain.model.valueobjects.ProjectId;

public record GetReviewByContractorIdAndProjectId(ContractorId contractorId, ProjectId projectId) {

}
