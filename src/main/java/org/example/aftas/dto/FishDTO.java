package org.example.aftas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class FishDTO {
    @NotBlank
    private String name;

    @NotNull
    private Double averageWeight;

    @Valid
    private List<HuntingDto> huntingList;

    @NotNull
    private LevelDTO level;
}
