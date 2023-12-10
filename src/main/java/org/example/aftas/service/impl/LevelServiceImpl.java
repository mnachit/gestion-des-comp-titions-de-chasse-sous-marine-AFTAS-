package org.example.aftas.service.impl;

import org.example.aftas.domain.Level;
import org.example.aftas.dto.LevelDTO;
import org.example.aftas.mapper.LevelMapper;
import org.example.aftas.repository.LevelRepository;
import org.example.aftas.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelServiceImpl implements LevelService {
    private LevelRepository levelRepository;
    @Autowired
    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public LevelDTO addLevel(LevelDTO levelDTO) {
        Level level = LevelMapper.toEntity(levelDTO);
        level = levelRepository.save(level);
        return LevelMapper.toDTO(level);
    }
}
