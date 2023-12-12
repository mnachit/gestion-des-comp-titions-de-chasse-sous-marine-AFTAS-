package org.example.aftas.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.aftas.domain.Member;
import org.example.aftas.dto.CompetitionDto;
import org.example.aftas.dto.MemberDTO;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.mapper.MemberMapper;
import org.example.aftas.service.MemberService;
import org.example.aftas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/member")
@RestController
@RequiredArgsConstructor
public class MemberRest {
    public MemberService memberService;

    @Autowired
    public MemberRest(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Response<MemberDTO>> addMember(@Valid @RequestBody MemberDTO memberDTO) {
        Response<MemberDTO> memberDtoResponse = new Response<>();
        try {
            memberDtoResponse.setResult(memberService.addMember(memberDTO));
            memberDtoResponse.setMessage("Member has been added successfully");
            return ResponseEntity.ok(memberDtoResponse);
        }catch (ValidationException e)
        {
            memberDtoResponse.setMessage("Competition has not been added");
            memberDtoResponse.setErrors(List.of(e.getErrorMessage()));
            return new ResponseEntity<>(memberDtoResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Response<List<MemberDTO>>> getAllMember() {
        Response<List<MemberDTO>> memberDtoResponse = new Response<>();
        try {
            List<MemberDTO> member = memberService.getAllMember();
            memberDtoResponse.setResult(member);
            memberDtoResponse.setMessage("Member has been added successfully");
            return ResponseEntity.ok(memberDtoResponse);
        }catch (ValidationException e)
        {
            memberDtoResponse.setMessage("Competition has not been added");
            memberDtoResponse.setErrors(List.of(e.getErrorMessage()));
            return new ResponseEntity<>(memberDtoResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
