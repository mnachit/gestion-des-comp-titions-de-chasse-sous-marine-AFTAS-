package org.example.aftas.repository;

import org.example.aftas.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    public Optional<Level> findByCode(Integer code);
}
