package org.example.aftas.service.impl;

import org.example.aftas.dto.MemberDTO;
import org.example.aftas.repository.MemberRepository;
import org.example.aftas.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberDTO addMember(MemberDTO memberDTO) {
        return null;
    }
}
