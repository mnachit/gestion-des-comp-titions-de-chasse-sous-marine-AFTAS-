package org.example.aftas.mapper;

import org.example.aftas.domain.Member;
import org.example.aftas.dto.MemberDTO;

public class MemberMapper {
    public static MemberDTO toDto(Member member)
    {

        return MemberDTO.builder()
                .num(member.getNum())
                .identityNumber(member.getIdentityNumber())
                .name(member.getName())
                .accessionDate(member.getAccessionDate())
                .familyName(member.getFamilyName())
                .nationality(member.getNationality())
                .build();
    }
    public static Member toEntity(MemberDTO memberDTO)
    {
        return Member.builder()
                .num(memberDTO.getNum())
                .identityNumber(memberDTO.getIdentityNumber())
                .name(memberDTO.getName())
                .accessionDate(memberDTO.getAccessionDate())
                .familyName(memberDTO.getFamilyName())
                .nationality(memberDTO.getNationality())
                .build();
    }
}
