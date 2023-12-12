package org.example.aftas.service.impl;

import org.example.aftas.domain.Member;
import org.example.aftas.dto.MemberDTO;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.mapper.MemberMapper;
import org.example.aftas.repository.MemberRepository;
import org.example.aftas.service.MemberService;
import org.example.aftas.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberDTO addMember(MemberDTO memberDTO) throws ValidationException {
        Optional<Member> optionalMember = memberRepository.getByIdentityNumber(memberDTO.getIdentityNumber());
        Optional<Member> optionalMember1 = memberRepository.getByNum(memberDTO.getNum());
        if (optionalMember.isPresent())
            throw new ValidationException(new ErrorMessage("identity number already exist"));
        if(optionalMember1.isPresent())
            throw new ValidationException(new ErrorMessage("num already exist"));

        Member member = memberRepository.save(MemberMapper.toEntity(memberDTO));
        if (member != null)
            return MemberMapper.toDto(member);
        else
            throw new ValidationException(new ErrorMessage("is not saved"));
    }

    @Override
    public List<MemberDTO> getAllMember() throws ValidationException {
        List<Member> member = memberRepository.findAll();
        List<MemberDTO> memberDTOS = new ArrayList<>();
        if (member != null) {
            for (Member member1 : member) {
                MemberDTO memberDTO = MemberMapper.toDto(member1);
                memberDTOS.add(memberDTO);
            }
            return memberDTOS;
        }
        else
            throw new ValidationException(new ErrorMessage("is not saved"));
    }
}
