package org.example.aftas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LevelDTO {

    private Long id;
    @NotNull(message = "code cannot be null")
    private Integer code;

    @NotBlank(message = "description cannot be blank")
    private String description;

    @NotNull(message = "point cannot be null")
    private Integer points;
}
