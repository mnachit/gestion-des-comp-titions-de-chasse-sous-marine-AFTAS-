package org.example.aftas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.aftas.domain.Competition;
import org.example.aftas.domain.Fish;
import org.example.aftas.domain.Member;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HuntingResponse {
    private int numberOfFish;
    private Fish fish;
    private Member member;
    private Competition competition;
}
