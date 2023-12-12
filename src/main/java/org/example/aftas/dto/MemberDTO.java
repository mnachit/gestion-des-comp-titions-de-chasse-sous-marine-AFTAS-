package org.example.aftas.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
    @NotNull(message = "num cannot be null")
    private Integer num;

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "familyName cannot be blank")
    private String familyName;

    @NotNull(message = "accessionDate cannot be null")
    private Date accessionDate;

    @NotBlank(message = "nationality cannot be blank" )
    private String nationality;

    @NotBlank(message = "identityNumber cannot be blank")
    private String identityNumber;
}
