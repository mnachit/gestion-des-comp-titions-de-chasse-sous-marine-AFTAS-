package org.example.aftas.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetitionDto {
    private String code;
    @NotNull(message = "date cannot be null")
    private Date date;
    @NotNull(message = "startTime cannot be null")
    private LocalTime startTime;
    @NotNull(message = "endTime cannot be null")
    private LocalTime endTime;
    @NotNull(message = "numberOfParticipants cannot be null")
    private Integer numberOfParticipants;
    @NotNull(message = "location cannot be null")
    private String location;
    @NotNull(message = "amount cannot be null")
    private double amount;
}
