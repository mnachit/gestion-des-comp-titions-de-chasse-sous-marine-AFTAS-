package org.example.aftas.service;

import org.example.aftas.dto.FishDTO;
import org.springframework.stereotype.Service;

@Service
public interface FishService {
    public FishDTO addFish(FishDTO fishDTO);
}
