package com.metasoft.restyle.platform.tracking.aplication.internal.commandservices;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Quotes;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateQuotesCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteQuotesCommand;
import com.metasoft.restyle.platform.tracking.domain.services.QuotesCommandService;
import com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories.QuotesRepository;

import com.metasoft.restyle.platform.tracking.infrastructure.persistence.jpa.repositories.TrackingRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class QuotesCommandServiceImpl implements QuotesCommandService {
    private final QuotesRepository quotesRepository;

    public QuotesCommandServiceImpl(QuotesRepository quotesRepository, TrackingRepository trackingRepository) {
        this.quotesRepository = quotesRepository;
    }



    @Override
    public Long handle(CreateQuotesCommand command) {
        var quotes = new Quotes(
                command.description01(),
                command.price01(),
                command.details01(),
                command.description02(),
                command.price02(),
                command.details02(),
                command.description03(),
                command.price03(),
                command.details03()
        );
        quotesRepository.save(quotes);
        return quotes.getId();
    }

    @Override
    public Optional<Quotes> handle(DeleteQuotesCommand command) {
        var quotes=quotesRepository.findById(command.quotesId())
                .orElseThrow(()-> new IllegalArgumentException("Not found"));
        quotesRepository.delete(quotes);
        return Optional.of(quotes);
    }

}
