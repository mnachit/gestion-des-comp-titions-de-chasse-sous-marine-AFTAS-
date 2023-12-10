package org.example.aftas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class LevelDTO {
    @NotNull
    private Integer code;

    @NotBlank
    private String description;

    @NotNull
    private Integer points;

    @Valid
    private List<FishDTO> fishList;
}
