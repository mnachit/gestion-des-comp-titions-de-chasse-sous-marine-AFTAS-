package org.example.aftas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FishDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @Size(min = 3, max = 20)
    private Double averageWeight;

    @Valid
    private List<HuntingDto> huntingList;

    @NotNull
    private LevelDTO level;
}
