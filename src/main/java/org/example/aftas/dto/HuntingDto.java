package org.example.aftas.dto;

import jakarta.validation.constraints.NotNull;

public class HuntingDto {
    @NotNull
    private int numberOfFish;

    @NotNull
    private CompetitionDto competition;

    @NotNull
    private MemberDTO member;

    @NotNull
    private FishDTO fish;
}
