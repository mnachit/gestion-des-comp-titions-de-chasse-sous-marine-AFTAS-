package org.example.aftas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double averageWeight;
    @OneToMany(mappedBy = "fish")
    private List<Hunting> huntingList;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;
}
