package org.example.aftas.service.impl;

import org.example.aftas.domain.Level;
import org.example.aftas.dto.LevelDTO;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.mapper.LevelMapper;
import org.example.aftas.repository.LevelRepository;
import org.example.aftas.service.LevelService;
import org.example.aftas.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {
    private LevelRepository levelRepository;
    @Autowired
    public LevelServiceImpl(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public LevelDTO addLevel(LevelDTO levelDTO) throws ValidationException {
        Optional<Level> optionalLevel = levelRepository.findByCode(levelDTO.getCode());
        if (optionalLevel.isPresent()) {
            throw new ValidationException(new ErrorMessage("Level with name already exists"));
        }
        Level level = LevelMapper.toEntity(levelDTO);
        level = levelRepository.save(level);
        return LevelMapper.toDTO(level);
    }

    @Override
    public List<LevelDTO> getAllLevel() {
        List<Level> level = levelRepository.findAll();
        List<LevelDTO> levelDTOS = new ArrayList<>();
        for (Level level1 : level) {
            LevelDTO LDto = LevelMapper.toDTO(level1);
            levelDTOS.add(LDto);
        }
        return levelDTOS;
    }

    @Override
    public LevelDTO getLevelById(Long id) {
        Level level = levelRepository.findById(id).get();
        return LevelMapper.toDTO(level);
    }
}
