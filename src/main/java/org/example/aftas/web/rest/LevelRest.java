package org.example.aftas.web.rest;

import lombok.RequiredArgsConstructor;
import org.example.aftas.dto.LevelDTO;
import org.example.aftas.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/level")
@RequiredArgsConstructor
public class LevelRest {
    private LevelService levelService;
    @Autowired
    public LevelRest(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping
    public LevelDTO addLevel(LevelDTO levelDTO) {
        LevelDTO level = levelService.addLevel(levelDTO);
        return level;
    }
}