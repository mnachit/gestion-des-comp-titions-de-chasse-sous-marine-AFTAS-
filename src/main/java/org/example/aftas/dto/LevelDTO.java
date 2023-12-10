package org.example.aftas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LevelDTO {
    @NotNull(message = "id cannot be null")
    @NotBlank(message = "id cannot be blank")
    private Long id;
    @NotNull(message = "code cannot be null")
    @Size(min = 3, max = 20)
    private Integer code;

    @NotBlank(message = "description cannot be blank")
    @Size(min = 3, max = 20)
    private String description;

    @NotNull(message = "point cannot be null")
    @Size(min = 3, max = 20)
    private Integer points;

    @Valid
    private List<FishDTO> fishList;
}
