package org.example.aftas.service;

import org.example.aftas.dto.LevelDTO;
import org.springframework.stereotype.Service;

@Service
public interface LevelService {
    public LevelDTO addLevel(LevelDTO levelDTO);
}
