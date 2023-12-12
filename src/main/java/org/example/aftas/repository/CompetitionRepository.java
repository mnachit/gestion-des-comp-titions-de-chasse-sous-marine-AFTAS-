package org.example.aftas.repository;

import org.example.aftas.domain.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    public Optional<Competition> findByCode(String code);
}
