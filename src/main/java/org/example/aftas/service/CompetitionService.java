package org.example.aftas.service;

import org.example.aftas.domain.Competition;
import org.example.aftas.dto.CompetitionDto;
import org.example.aftas.handler.exception.ValidationException;
import org.springframework.stereotype.Service;

@Service
public interface CompetitionService {
    public CompetitionDto addCompetition(Competition competition) throws ValidationException;
}
