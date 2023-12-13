package org.example.aftas.service.impl;

import lombok.NoArgsConstructor;
import org.example.aftas.domain.Fish;
import org.example.aftas.dto.FishDTO;
import org.example.aftas.dto.response.FishResponse;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.mapper.EntityToFishResponse;
import org.example.aftas.mapper.FishMapper;
import org.example.aftas.repository.FishRepository;
import org.example.aftas.service.FishService;
import org.example.aftas.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class FishServiceImpl implements FishService {
    private FishRepository fishRepository;

    @Autowired
    public FishServiceImpl(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }
    @Override
    public FishDTO addFish(FishDTO fishDTO) throws ValidationException {
        Optional<Fish> optionalFish = fishRepository.findByName(fishDTO.getName());
        if (optionalFish.isPresent()) {
            throw new ValidationException(new ErrorMessage("Fish with name already exists"));
        }
        Fish fish = FishMapper.toEntity(fishDTO);
        fish = fishRepository.save(fish);
        return FishMapper.toDTO(fish);
    }

    @Override
    public List<FishDTO> getAllFish() {
        List<Fish> fish = fishRepository.findAll();
        List<FishDTO> fishDTOS = new ArrayList<>();
        for (Fish fish1 : fish) {
            FishDTO FDto = FishMapper.toDTO(fish1);
            fishDTOS.add(FDto);
        }
        return fishDTOS;
    }

    @Override
    public List<FishResponse> getAllFish1() {
        List<Fish> fish = fishRepository.findAll();
        List<FishResponse> fishDTOS = new ArrayList<>();
        for (Fish fish1 : fish) {
            FishResponse FDto = EntityToFishResponse.ToFishResponse(fish1);
            fishDTOS.add(FDto);
        }
        return fishDTOS;
    }

    @Override
    public FishDTO getFishById(Long id) {
        Fish fish = fishRepository.findById(id).get();
        return FishMapper.toDTO(fish);
    }
}
