package org.example.aftas.mapper;

import org.example.aftas.domain.Competition;
import org.example.aftas.domain.Member;
import org.example.aftas.domain.Ranking;
import org.example.aftas.dto.RankingDto;

public class RankingMapper {
    public static Ranking toEntity(RankingDto rankingDto) {
        return Ranking.builder()
                .rank(rankingDto.getRank())
                .score(rankingDto.getScore())
                .member(Member.builder().id(rankingDto.getMember()).build())
                .competition(Competition.builder().id(rankingDto.getCompetition()).build())
                .build();
    }
    public static RankingDto toDto(Ranking ranking) {
        return RankingDto.builder()
                .rank(ranking.getRank())
                .score(ranking.getScore())
                .member(ranking.getMember().getId())
                .competition(ranking.getCompetition().getId())
                .build();
    }
}
