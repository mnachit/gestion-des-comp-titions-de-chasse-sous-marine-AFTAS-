package org.example.aftas.mapper;

import org.example.aftas.domain.Level;
import org.example.aftas.dto.LevelDTO;

public class LevelMapper {

    public static Level toEntity(LevelDTO levelDTO) {
        return Level.builder()
                .id(levelDTO.getId())
                .code(levelDTO.getCode())
                .description(levelDTO.getDescription())
                .points(levelDTO.getPoints())
                .build();
    }
    public static LevelDTO toDTO(Level level) {
        return LevelDTO.builder()
                .id(level.getId())
                .code(level.getCode())
                .description(level.getDescription())
                .points(level.getPoints())
                .build();
    }
}
