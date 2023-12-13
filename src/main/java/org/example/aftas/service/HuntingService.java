package org.example.aftas.service;

import org.example.aftas.dto.HuntingDto;
import org.example.aftas.handler.exception.ValidationException;
import org.example.aftas.handler.exception.ValidationExceptionTest;
import org.springframework.stereotype.Service;

@Service
public interface HuntingService {
    public HuntingDto addHunting(HuntingDto huntingDto) throws ValidationException;
    public HuntingDto addHunting1(HuntingDto huntingDto) throws ValidationExceptionTest;
}
