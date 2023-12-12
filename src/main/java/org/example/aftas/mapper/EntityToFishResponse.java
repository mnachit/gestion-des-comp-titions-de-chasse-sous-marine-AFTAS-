package org.example.aftas.mapper;

import org.example.aftas.domain.Fish;
import org.example.aftas.domain.Level;
import org.example.aftas.dto.response.FishReponse;
import org.example.aftas.dto.response.LevelResponse;

public class EntityToFishResponse {
    public static FishReponse ToFishResponse(Fish fishDTO) {
        FishReponse fishResponse = new FishReponse();
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
