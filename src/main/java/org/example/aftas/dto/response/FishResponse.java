package org.example.aftas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FishResponse {
    private String name;
    private Double averageWeight;
    private LevelResponse level;
}
