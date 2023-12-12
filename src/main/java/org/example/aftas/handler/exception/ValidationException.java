package org.example.aftas.handler.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.aftas.utils.ErrorMessage;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ValidationException extends Exception{
    private ErrorMessage errorMessage;
}