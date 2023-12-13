package org.example.aftas.repository;

import org.example.aftas.domain.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HuntingRepository extends JpaRepository<Hunting, Long> {
    public Optional<Hunting> findByCompetitionIdAndMemberIdAndFishId(Long competitionId, Long memberId, Long fishId);
}
