package com.mathiasuy.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mathiasuy.responses.ErrorMessage;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HandlerException {

    @ExceptionHandler(PetNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage errorBD(PetNotFound ex) {
        return new ErrorMessage(ex.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessage errorBD(Exception ex) {
    	return new ErrorMessage(ex.getMessage());
    }

}