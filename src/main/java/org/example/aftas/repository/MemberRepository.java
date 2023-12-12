package org.example.aftas.repository;

import org.example.aftas.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>{
    public Optional<Member> getByIdentityNumber(String identityNumber);
    public Optional<Member> getByNum(Integer num);
}
