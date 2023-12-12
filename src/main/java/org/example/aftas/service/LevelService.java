package org.example.aftas.service;

import org.example.aftas.dto.LevelDTO;
import org.example.aftas.handler.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LevelService {
    public LevelDTO addLevel(LevelDTO levelDTO) throws ValidationException;
    public List<LevelDTO> getAllLevel();
    public LevelDTO getLevelById(Long id);
}
