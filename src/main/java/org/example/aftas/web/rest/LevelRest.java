package org.example.aftas.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.aftas.dto.LevelDTO;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/level")
public class LevelRest {
    private LevelService levelService;
    @Autowired
    public LevelRest(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping
    public ResponseEntity<LevelDTO> addLevel(@Valid @RequestBody LevelDTO levelDTO) throws ValidationException {
        LevelDTO level = levelService.addLevel(levelDTO);
        return new ResponseEntity<>(level, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<LevelDTO>> getLevel() {
        List<LevelDTO> level = levelService.getAllLevel();
        return new ResponseEntity<>(level, HttpStatus.CREATED);
    }
}