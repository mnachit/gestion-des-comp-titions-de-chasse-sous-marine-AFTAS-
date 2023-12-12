package org.example.aftas.mapper;

import org.example.aftas.domain.Competition;
import org.example.aftas.dto.CompetitionDto;

public class CompetitionMapper {
    public static CompetitionDto toDto(Competition competition)
    {

        return CompetitionDto.builder()
                .code(competition.getCode())
                .date(competition.getDate())
                .startTime(competition.getStartTime())
                .endTime(competition.getEndTime())
                .numberOfParticipants(competition.getNumberOfParticipants())
                .location(competition.getLocation())
                .amount(competition.getAmount())
                .build();
    }
    public static Competition toEntity(CompetitionDto competitionDto)
    {
        return Competition.builder()
                .code(competitionDto.getCode())
                .date(competitionDto.getDate())
                .startTime(competitionDto.getStartTime())
                .endTime(competitionDto.getEndTime())
                .numberOfParticipants(competitionDto.getNumberOfParticipants())
                .location(competitionDto.getLocation())
                .amount(competitionDto.getAmount())
                .build();
    }
}
