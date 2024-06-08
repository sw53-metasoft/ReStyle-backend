package com.metasoft.restyle.platform.tracking.domain.services;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Quotes;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllQuotesQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetQuotesByIdQuery;

import java.util.List;
import java.util.Optional;

public interface QuotesQueryService {
    List<Quotes>handle(GetAllQuotesQuery query);
    Optional<Quotes> handle(GetQuotesByIdQuery query);
}
