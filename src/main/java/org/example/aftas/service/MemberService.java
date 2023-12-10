package org.example.aftas.service;

import org.example.aftas.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    public MemberDTO addMember(MemberDTO memberDTO);
}
