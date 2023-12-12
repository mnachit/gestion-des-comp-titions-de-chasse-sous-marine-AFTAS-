package org.example.aftas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.aftas.domain.Level;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FishReponse {
    private String name;
    private Double averageWeight;
    private LevelResponse level;
}
