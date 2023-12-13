package org.example.aftas.repository;

import org.example.aftas.domain.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
    Optional<Ranking> findByCompetitionIdAndMemberId(Long competitionId, Long memberId);
}
