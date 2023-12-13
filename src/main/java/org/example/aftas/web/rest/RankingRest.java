package org.example.aftas.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.aftas.dto.RankingDto;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.handler.exception.ValidationExceptionTest;
import org.example.aftas.service.RankingService;
import org.example.aftas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping({"/api/v1/ranking"})
@RequiredArgsConstructor
public class RankingRest {
    private RankingService rankingService;
    @Autowired
    public RankingRest(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @PostMapping
    public ResponseEntity<Response<RankingDto>> addRanking(@Valid @RequestBody RankingDto rankingDto) {
        Response<RankingDto> response = new Response<>();

        try {
            RankingDto addedRankingDto = rankingService.addRanking(rankingDto);
            response.setMessage("Ranking has been added successfully");
            response.setResult(addedRankingDto);
            return ResponseEntity.ok(response);
        } catch (ValidationExceptionTest e) {
            response.setMessage("Competition has not been added");
            response.setErrors(new ArrayList<>(e.getErrorMessages()));
            return ResponseEntity.ok(response);
        }
    }



}
