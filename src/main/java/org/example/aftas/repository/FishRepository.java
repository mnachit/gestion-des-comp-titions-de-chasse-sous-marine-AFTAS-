package org.example.aftas.repository;

import org.example.aftas.domain.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long> {
    public Optional<Fish> findByName(String name);
}
