package com.institution.college.config;

import com.institution.college.dto.ResponseDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseDTO handleInvalidInput(ValidationException ex) {
        return new ResponseDTO(BAD_REQUEST.value(), ex.getMessage(), null, new Date());
    }

}