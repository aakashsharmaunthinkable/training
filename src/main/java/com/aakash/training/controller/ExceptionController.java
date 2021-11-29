package com.aakash.training.controller;

import com.aakash.training.exceptions.ExceptionResponse;
import com.aakash.training.exceptions.MobileNumberException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.jws.WebResult;
import java.util.Date;

@RestController
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MobileNumberException.class)
    public String mobileNumberException(Exception exception, WebResult result) {
        return exception.getLocalizedMessage();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        int len = ex.getMessage().split(";").length;
        String message = ex.getMessage().split(";")[len-1];
        message = message.substring(18, message.length()-3);
        return new ResponseEntity<>(new ExceptionResponse(request.getDescription(false), message, new Date()), HttpStatus.NOT_ACCEPTABLE);
    }
}
