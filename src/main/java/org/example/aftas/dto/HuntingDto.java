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
public class HuntingDto {
    @NotNull(message = "Number of fish is required")
    private int numberOfFish;

    @NotNull(message = "Competition is required")
    private Long competition;

    @NotNull(message = "Member is required")
    private Long member;

    @NotNull(message = "Fish is required")
    private Long fish;

    @NotNull(message = "Average weight is required")
    private Double averageWeight;
}
