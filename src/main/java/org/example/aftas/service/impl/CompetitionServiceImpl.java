package org.example.aftas.service.impl;

import org.example.aftas.domain.Competition;
import org.example.aftas.dto.CompetitionDto;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.mapper.CompetitionMapper;
import org.example.aftas.repository.CompetitionRepository;
import org.example.aftas.service.CompetitionService;
import org.example.aftas.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {
    private CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public CompetitionDto addCompetition(Competition competition) throws ValidationException{
        if (competition.getDate().before(new Date()))
            throw  new ValidationException(new ErrorMessage("date must be after today"));
        if(competition.getStartTime().isAfter(competition.getEndTime()))
            throw  new ValidationException(new ErrorMessage("start time must be before end time"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(competition.getDate());

// Set the code in the desired format
        competition.setCode("bm-" + formattedDate);
        Optional<Competition> competitionOptional = competitionRepository.findByCode(competition.getCode());
        if (competitionOptional.isPresent())
            throw  new ValidationException(new ErrorMessage("code already exist"));
        if (competition.getNumberOfParticipants() < 5)
            throw  new ValidationException(new ErrorMessage("number of participants must be greater than 2"));
        if (competition.getNumberOfParticipants() > 20)
            throw  new ValidationException(new ErrorMessage("number of participants must be less than 10"));

        Competition competition1 = competitionRepository.save(competition);
        if (competition1 != null)
            return CompetitionMapper.toDto(competition1);
        else
            throw  new ValidationException(new ErrorMessage("is not saved"));
    }
}
