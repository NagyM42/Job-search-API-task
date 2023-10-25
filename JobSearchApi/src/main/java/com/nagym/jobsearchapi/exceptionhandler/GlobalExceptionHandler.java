package com.nagym.jobsearchapi.exceptionhandler;

import com.nagym.jobsearchapi.dtos.ErrorResponseDto;
import com.nagym.jobsearchapi.exceptions.InvalidClientEmailException;
import com.nagym.jobsearchapi.exceptions.InvalidClientNameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({InvalidClientNameException.class, InvalidClientEmailException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handleClientErrorException(Exception exception){
    return new ErrorResponseDto(HttpStatus.BAD_REQUEST, exception.getMessage());
  }
}
