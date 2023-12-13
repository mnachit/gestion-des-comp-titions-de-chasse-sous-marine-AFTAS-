package org.example.aftas.mapper;

import org.example.aftas.domain.Fish;
import org.example.aftas.domain.Level;
import org.example.aftas.dto.response.FishResponse;
import org.example.aftas.dto.response.LevelResponse;

public class EntityToFishResponse {
    public static FishResponse ToFishResponse(Fish fishDTO) {
        FishResponse fishResponse = new FishResponse();
        fishResponse.setName(fishDTO.getName());
        fishResponse.setAverageWeight(fishDTO.getAverageWeight());

        LevelResponse levelResponse = new LevelResponse();
        Level level = fishDTO.getLevel();
        if (level != null) {
            levelResponse.setId(level.getId());
            levelResponse.setCode(level.getCode());
            levelResponse.setDescription(level.getDescription());
            levelResponse.setPoints(level.getPoints());
        }

        fishResponse.setLevel(levelResponse);

        return fishResponse;
    }
}
