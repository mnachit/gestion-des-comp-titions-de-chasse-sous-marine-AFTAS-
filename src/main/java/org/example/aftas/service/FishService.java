package org.example.aftas.service;

import org.example.aftas.dto.FishDTO;
import org.example.aftas.dto.response.FishResponse;
import org.example.aftas.handler.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FishService {
    public FishDTO addFish(FishDTO fishDTO) throws ValidationException;
    public List<FishDTO> getAllFish();
    public List<FishResponse> getAllFish1();
    public FishDTO getFishById(Long id);
}
