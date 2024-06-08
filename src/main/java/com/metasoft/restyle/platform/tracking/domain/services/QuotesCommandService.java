package com.metasoft.restyle.platform.tracking.domain.services;
import com.metasoft.restyle.platform.tracking.domain.model.aggregates.Quotes;
import com.metasoft.restyle.platform.tracking.domain.model.commands.CreateQuotesCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.DeleteQuotesCommand;
import com.metasoft.restyle.platform.tracking.domain.model.commands.UpdateQuotesCommand;
import java.util.Optional;

public interface QuotesCommandService {
    Long  handle(CreateQuotesCommand command);
    Optional<Quotes> handle (DeleteQuotesCommand command);
}
