package org.example.aftas.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Response<T> {
    private String message;
    private T result;
    private List<ErrorMessage> errors;
}
