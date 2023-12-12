package org.example.aftas.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.aftas.domain.Competition;
import org.example.aftas.dto.CompetitionDto;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.mapper.CompetitionMapper;
import org.example.aftas.service.CompetitionService;
import org.example.aftas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/competition")
public class CompetitionRest {
    private CompetitionService competitionService;
    @Autowired
    public CompetitionRest(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @PostMapping
    public ResponseEntity<Response<CompetitionDto>> addCompetition(@Valid @RequestBody CompetitionDto competitionDto){
        Response<CompetitionDto> competitionDtoResponse = new Response<>();
        Competition competition = CompetitionMapper.toEntity(competitionDto);
        try {
            competitionDtoResponse.setResult(competitionService.addCompetition(competition));
            competitionDtoResponse.setMessage("Competition has been added successfully");
            return new ResponseEntity<>(competitionDtoResponse, HttpStatus.CREATED);
        }catch (ValidationException e)
        {
            competitionDtoResponse.setMessage("Competition has not been added");
            competitionDtoResponse.setErrors(List.of(e.getErrorMessage()));
            return new ResponseEntity<>(competitionDtoResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
