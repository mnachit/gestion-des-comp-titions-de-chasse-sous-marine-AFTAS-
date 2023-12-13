package org.example.aftas.service.impl;

import org.example.aftas.domain.Fish;
import org.example.aftas.domain.Hunting;
import org.example.aftas.domain.Level;
import org.example.aftas.domain.Ranking;
import org.example.aftas.dto.HuntingDto;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.handler.exception.ValidationExceptionTest;
import org.example.aftas.mapper.HuntingMapper;
import org.example.aftas.mapper.RankingMapper;
import org.example.aftas.repository.*;
import org.example.aftas.service.HuntingService;
import org.example.aftas.service.RankingService;
import org.example.aftas.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HuntingServiceImpl implements HuntingService {
    private HuntingRepository huntingRepository;
    private MemberRepository memberRepository;
    private CompetitionRepository competitionRepository;
    private FishRepository fishRepository;
    private LevelRepository levelRepository;
    private RankingService rankingService;

    @Autowired
    public HuntingServiceImpl(HuntingRepository huntingRepository, MemberRepository memberRepository, CompetitionRepository competitionRepository, FishRepository fishRepository, LevelRepository levelRepository, RankingService rankingService) {
        this.huntingRepository = huntingRepository;
        this.memberRepository = memberRepository;
        this.competitionRepository = competitionRepository;
        this.fishRepository = fishRepository;
        this.levelRepository = levelRepository;
        this.rankingService = rankingService;
    }

    @Override
    public HuntingDto addHunting(HuntingDto huntingDto) throws ValidationException {
        if(!memberRepository.existsById(huntingDto.getMember()))
            throw new ValidationException(new ErrorMessage("member id not found"));
        if(!competitionRepository.existsById(huntingDto.getCompetition()))
            throw new ValidationException(new ErrorMessage("competition id not found"));
        if (!fishRepository.existsById(huntingDto.getFish()))
            throw new ValidationException(new ErrorMessage("fish id not found"));
        if(huntingDto.getNumberOfFish() <= 0)
            throw new ValidationException(new ErrorMessage("weight must be greater than 0"));
        Hunting hunting = huntingRepository.save(HuntingMapper.ToEntity(huntingDto));
        if (hunting != null)
            return HuntingMapper.ToDto(hunting);
        else
            throw new ValidationException(new ErrorMessage("is not saved"));
    }

    @Override
    public HuntingDto addHunting1(HuntingDto huntingDto) throws ValidationExceptionTest {
        Optional<Fish> fish = fishRepository.findById(huntingDto.getFish());
        List<ErrorMessage> errorMessages = new ArrayList<>();
        if(fish.isPresent() && huntingDto.getAverageWeight() >= fish.get().getAverageWeight()) {
            if (!memberRepository.existsById(huntingDto.getMember()))
                errorMessages.add(new ErrorMessage("member id not found"));

            if (!competitionRepository.existsById(huntingDto.getCompetition()))
                errorMessages.add(new ErrorMessage("competition id not found"));

            if (!fishRepository.existsById(huntingDto.getFish()))
                errorMessages.add(new ErrorMessage("fish id not found"));

            if (huntingDto.getNumberOfFish() <= 0)
                errorMessages.add(new ErrorMessage("weight must be greater than 0"));
            if (!errorMessages.isEmpty()) {
                throw new ValidationExceptionTest(errorMessages);
            }
            if (huntingRepository.findByCompetitionIdAndMemberIdAndFishId(huntingDto.getCompetition(), huntingDto.getMember(), huntingDto.getFish()).isEmpty()) {
                Hunting hunting = huntingRepository.save(HuntingMapper.ToEntity(huntingDto));
                return HuntingMapper.ToDto(hunting);
            } else {
                Optional<Hunting> hunting = huntingRepository.findByCompetitionIdAndMemberIdAndFishId(huntingDto.getCompetition(), huntingDto.getMember(), huntingDto.getFish());
                hunting.get().setNumberOfFish(hunting.get().getNumberOfFish() + huntingDto.getNumberOfFish());
                huntingRepository.save(hunting.get());
                Ranking ranking = new Ranking();
                ranking.setCompetition(hunting.get().getCompetition());
                ranking.setMember(hunting.get().getMember());
                ranking.setScore(CalculeScore(huntingDto));
                ranking.setRank(0);
                rankingService.addRanking(RankingMapper.toDto(ranking));
                return HuntingMapper.ToDto(hunting.get());
            }
        }
        else {
            errorMessages.add(new ErrorMessage("average weight must be greater than or equal to fish average weight"));
            throw new ValidationExceptionTest(errorMessages);
        }
    }

    public Integer CalculeScore(HuntingDto huntingDto)
    {
        Optional<Fish> fish = fishRepository.findById(huntingDto.getFish());
        Optional<Level> level = levelRepository.findById(fish.get().getLevel().getId());
        Integer score = huntingDto.getNumberOfFish() * level.get().getPoints();
            return score;
    }


}
