package org.example.aftas.service;

import org.example.aftas.domain.Member;
import org.example.aftas.dto.MemberDTO;
import org.example.aftas.handler.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {
    public MemberDTO addMember(MemberDTO memberDTO) throws ValidationException;
    public List<MemberDTO> getAllMember() throws ValidationException;
}
