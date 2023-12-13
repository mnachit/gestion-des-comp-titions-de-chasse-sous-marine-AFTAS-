package org.example.aftas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RankingDto {
    @NotNull(message = "rank cannot be null")
    private int rank;
    @NotNull(message = "score cannot be null")
    private int score;
    @NotNull(message = "member cannot be null")
    private Long member;
    @NotNull(message = "competition cannot be null")
    private Long competition;
}
