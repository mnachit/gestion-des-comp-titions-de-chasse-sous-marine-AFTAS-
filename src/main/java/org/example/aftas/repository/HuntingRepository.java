package org.example.aftas.repository;

import org.example.aftas.domain.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuntingRepository extends JpaRepository<Hunting, Long> {
}
