package org.example.aftas.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FishDTO {
    @NotBlank(message = "name cannot be blank")
    @Size(min = 3, max = 20)
    private String name;

    @NotNull(message = "average weight cannot be null")
    private Double averageWeight;

    @NotNull(message = "level cannot be null")
    @Min(value = 1, message = "level must be greater than 0")
    private Long level;
}
