package com.metasoft.restyle.platform.tracking.domain.model.commands;

public record CreateQuotesCommand (
        String description01,
        Float price01,
        String details01,

        String description02,
        Float price02,
        String details02,

        String description03,
        Float price03,
        String details03 ) {
}

