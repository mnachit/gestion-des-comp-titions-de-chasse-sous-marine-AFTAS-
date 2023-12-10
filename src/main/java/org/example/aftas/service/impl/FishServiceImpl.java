package org.example.aftas.service.impl;

import org.example.aftas.dto.FishDTO;
import org.example.aftas.repository.FishRepository;
import org.example.aftas.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishServiceImpl implements FishService {
    private FishRepository fishRepository;

    @Autowired
    public FishServiceImpl(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }
    @Override
    public FishDTO addFish(FishDTO fishDTO) {
        return null;
    }
}
