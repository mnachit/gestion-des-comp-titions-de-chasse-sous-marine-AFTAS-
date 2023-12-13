package org.example.aftas.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.aftas.dto.FishDTO;
import org.example.aftas.dto.response.FishResponse;
import org.example.aftas.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fish")
public class FishRest {
    private FishService fishService;

    @Autowired
    public FishRest(FishService fishService) {
        this.fishService = fishService;
    }

    @PostMapping
    public ResponseEntity<FishDTO> addFish(@Valid @RequestBody FishDTO fishDTO) {
        try {
            fishService.addFish(fishDTO);
            return new ResponseEntity<>(fishDTO, HttpStatus.CREATED);
        } catch (Exception e) {
//            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<FishResponse>> getAllFish1() {
        try {
            return new ResponseEntity<>(fishService.getAllFish1(),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
