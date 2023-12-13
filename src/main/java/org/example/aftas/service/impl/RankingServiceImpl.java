package org.example.aftas.service.impl;

import org.example.aftas.domain.Competition;
import org.example.aftas.domain.Member;
import org.example.aftas.domain.Ranking;
import org.example.aftas.dto.RankingDto;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.handler.exception.ValidationExceptionTest;
import org.example.aftas.mapper.RankingMapper;
import org.example.aftas.repository.CompetitionRepository;
import org.example.aftas.repository.MemberRepository;
import org.example.aftas.repository.RankingRepository;
import org.example.aftas.service.RankingService;
import org.example.aftas.utils.ErrorMessage;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RankingServiceImpl implements RankingService {
    private RankingRepository rankingRepository;
    private MemberRepository memberRepository;
    private CompetitionRepository competitionRepository;
    public RankingServiceImpl(RankingRepository rankingRepository, MemberRepository memberRepository, CompetitionRepository competitionRepository) {
        this.rankingRepository = rankingRepository;
        this.memberRepository = memberRepository;
        this.competitionRepository = competitionRepository;
    }
    @Override
    public RankingDto addRanking(RankingDto rankingDTO) throws ValidationExceptionTest {
        Optional<Competition> competition = competitionRepository.findById(rankingDTO.getCompetition());
        List<ErrorMessage> errorMessages = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        String formattedDate1 = dateFormat.format(competition.get().getDate());
        if (competition.isPresent() && formattedDate1.equals(formattedDate)) {
            if (!memberRepository.existsById(rankingDTO.getMember()) || !competitionRepository.existsById(rankingDTO.getCompetition())) {
                errorMessages.add(new ErrorMessage("member or competition id not found"));
            }
            if (!errorMessages.isEmpty()) {
                throw new ValidationExceptionTest(errorMessages);
            }
            if (rankingRepository.findByCompetitionIdAndMemberId(rankingDTO.getCompetition(), rankingDTO.getMember()).isPresent()) {
                Ranking ranking = rankingRepository.findByCompetitionIdAndMemberId(rankingDTO.getCompetition(), rankingDTO.getMember()).get();
                ranking.setScore(ranking.getScore() + rankingDTO.getScore());
                return RankingMapper.toDto(rankingRepository.save(ranking));
            }
            return RankingMapper.toDto(rankingRepository.save(RankingMapper.toEntity(rankingDTO)));
        }
        else
        {
            errorMessages.add(new ErrorMessage("You do not have access"));
            throw new ValidationExceptionTest(errorMessages);
        }
    }
}
