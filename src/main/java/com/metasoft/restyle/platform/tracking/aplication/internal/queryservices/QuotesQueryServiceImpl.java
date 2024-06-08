package com.metasoft.restyle.platform.tracking.aplication.internal.queryservices;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Quotes;

import com.metasoft.restyle.platform.tracking.domain.model.queries.GetAllQuotesQuery;
import com.metasoft.restyle.platform.tracking.domain.model.queries.GetQuotesByIdQuery;

import com.metasoft.restyle.platform.tracking.domain.services.QuotesQueryService;
import com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories.QuotesRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class QuotesQueryServiceImpl implements QuotesQueryService {

    private QuotesRepository quotesRepository;
    public QuotesQueryServiceImpl(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @Override
    public List<Quotes> handle(GetAllQuotesQuery query) {
        return quotesRepository.findAll();
    }

    @Override
    public Optional<Quotes> handle(GetQuotesByIdQuery query) {
        return quotesRepository.findById(query.id());
    }
}
