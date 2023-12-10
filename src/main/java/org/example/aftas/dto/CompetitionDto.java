package org.example.aftas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.aftas.domain.Hunting;
import org.example.aftas.domain.Ranking;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetitionDto {
    @NotNull(message = "code cannot be null")
    @NotBlank(message = "code cannot be blank")
    private String code;
    @NotNull(message = "date cannot be null")
    @NotBlank(message = "date cannot be blank")
    private LocalDateTime date;
    @NotNull(message = "startTime cannot be null")
    @NotBlank(message = "startTime cannot be blank")
    private LocalTime startTime;
    @NotNull(message = "endTime cannot be null")
    @NotBlank(message = "endTime cannot be blank")
    private LocalTime endTime;
    @NotNull(message = "numberOfParticipants cannot be null")
    @NotBlank(message = "numberOfParticipants cannot be blank")
    private Integer numberOfParticipants;
    @NotNull(message = "location cannot be null")
    @NotBlank(message = "location cannot be blank")
    private String location;
    @NotNull(message = "amount cannot be null")
    @NotBlank(message = "amount cannot be blank")
    private double amount;
    @Valid
    @NotNull(message = "ranking cannot be null")
    private List<RankingDto> rankings;
    @Valid
    @NotNull(message = "hunting cannot be null")
    private List<Hunting> huntingList;
}
