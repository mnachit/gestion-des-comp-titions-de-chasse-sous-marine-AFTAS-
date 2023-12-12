package org.example.aftas.mapper;

import org.example.aftas.domain.Fish;
import org.example.aftas.domain.Level;
import org.example.aftas.dto.FishDTO;

public class FishMapper {
    public static Fish toEntity(FishDTO fishDTO) {
        return Fish.builder()
                .name(fishDTO.getName())
                .averageWeight(fishDTO.getAverageWeight())
                .level(
                        Level.builder()
                                .id(fishDTO.getLevel())
                                .build()
                )
                .build();
    }
    public static FishDTO toDTO(Fish fish) {
        return FishDTO.builder()
                .name(fish.getName())
                .averageWeight(fish.getAverageWeight())
                .level(fish.getLevel().getId())
                .build();
    }
}
