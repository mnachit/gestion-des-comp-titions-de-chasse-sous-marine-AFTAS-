package org.example.aftas.mapper;

import org.example.aftas.domain.Competition;
import org.example.aftas.domain.Fish;
import org.example.aftas.domain.Hunting;
import org.example.aftas.domain.Member;
import org.example.aftas.dto.HuntingDto;

public class HuntingMapper {
    public static Hunting ToEntity(HuntingDto huntingDto)
    {
        return Hunting.builder()
                .numberOfFish(huntingDto.getNumberOfFish())
                .competition(Competition.builder().id(huntingDto.getCompetition()).build())
                .member(Member.builder().id(huntingDto.getMember()).build())
                .fish(Fish.builder().id(huntingDto.getFish()).build()).build();
    }
    public static HuntingDto ToDto(Hunting hunting)
    {
        return HuntingDto.builder()
                .numberOfFish(hunting.getNumberOfFish())
                .competition(hunting.getCompetition().getId())
                .member(hunting.getMember().getId())
                .fish(hunting.getFish().getId()).build();
    }
}
