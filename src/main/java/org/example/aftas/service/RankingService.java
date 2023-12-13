package org.example.aftas.service;

import org.example.aftas.dto.RankingDto;
import org.example.aftas.handler.exception.ValidationExceptionTest;
import org.springframework.stereotype.Service;

@Service
public interface RankingService {
    public RankingDto addRanking(RankingDto rankingDTO) throws ValidationExceptionTest;
}
