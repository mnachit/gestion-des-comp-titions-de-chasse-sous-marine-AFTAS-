package org.example.aftas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelResponse {
    private Long id;
    private Integer code;
    private String description;
    private Integer points;
}
