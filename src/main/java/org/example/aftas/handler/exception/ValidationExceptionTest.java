package org.example.aftas.handler.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.aftas.utils.ErrorMessage;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class ValidationExceptionTest extends Exception{
    private List<ErrorMessage> errorMessages;

    public ValidationExceptionTest(List<ErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
