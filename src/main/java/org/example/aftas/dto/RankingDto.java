package org.example.aftas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RankingDto {
    @NotNull(message = "rank cannot be null")
    @NotBlank(message = "rank cannot be blank")
    private int rank;
    @NotNull(message = "score cannot be null")
    @NotBlank(message = "score cannot be blank")
    private int score;
}
