package org.example.aftas.dto;

import jakarta.validation.constraints.NotNull;

public class RankingDTO {
    @NotNull
    private int rank;

    @NotNull
    private int score;

    @NotNull
    private CompetitionDto competition;

    @NotNull
    private MemberDTO member;
}
