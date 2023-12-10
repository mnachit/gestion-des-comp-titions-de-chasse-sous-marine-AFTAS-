package org.example.aftas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
