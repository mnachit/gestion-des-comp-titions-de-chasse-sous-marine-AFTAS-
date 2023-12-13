package org.example.aftas.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.aftas.dto.HuntingDto;
import org.example.aftas.dto.MemberDTO;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.handler.exception.ValidationExceptionTest;
import org.example.aftas.service.HuntingService;
import org.example.aftas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/api/v1/hunting"})
@RequiredArgsConstructor
public class HuntingRest {
    private HuntingService huntingService;

    @Autowired
    public HuntingRest(HuntingService huntingService) {
        this.huntingService = huntingService;
    }

    @PostMapping
    public ResponseEntity<Response<HuntingDto>> addHunting(@Valid @RequestBody HuntingDto huntingDto) {
        Response<HuntingDto> memberDtoResponse = new Response<>();
        try {
            memberDtoResponse.setResult(huntingService.addHunting1(huntingDto));
            memberDtoResponse.setMessage("Member has been added successfully");
            return ResponseEntity.ok(memberDtoResponse);
        }catch (ValidationExceptionTest e)
        {
            memberDtoResponse.setMessage("Competition has not been added");
            memberDtoResponse.setErrors(new ArrayList<>(e.getErrorMessages()));
            return ResponseEntity.ok(memberDtoResponse);
        }
    }
}
