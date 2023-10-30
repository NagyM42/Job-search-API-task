package com.nagym.jobsearchapi.exceptionhandler;

import com.nagym.jobsearchapi.dtos.ErrorResponseDto;
import com.nagym.jobsearchapi.exceptions.ClientEmailNotUniqueException;
import com.nagym.jobsearchapi.exceptions.InvalidApiKeyException;
import com.nagym.jobsearchapi.exceptions.InvalidClientEmailException;
import com.nagym.jobsearchapi.exceptions.InvalidClientNameLengthException;
import com.nagym.jobsearchapi.exceptions.InvalidPositionIdException;
import com.nagym.jobsearchapi.exceptions.InvalidPositionLocationLengthException;
import com.nagym.jobsearchapi.exceptions.InvalidPositionNameLegthException;
import com.nagym.jobsearchapi.exceptions.PositionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({InvalidClientEmailException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handleClientEmailException(Exception exception) {

    String message = "Error: Invalid e-mail address format!";
    return new ErrorResponseDto(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler({InvalidClientNameLengthException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handleClientNameException(Exception exception) {

    String message = "Error: Client name exceeds 50 characters!";
    return new ErrorResponseDto(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler({InvalidPositionNameLegthException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handlePositionNameLengthException(Exception exception) {

    String message = "Error: Position name exceeds 50 characters!";
    return new ErrorResponseDto(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler({InvalidPositionLocationLengthException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handlePositionLocationNameLengthException(Exception exception) {

    String message = "Error: Position's Location name exceeds 50 characters!";
    return new ErrorResponseDto(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler({InvalidApiKeyException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handleInvalidClientIDException(Exception exception) {

    String message = "Error: Invalid Client UUID!";
    return new ErrorResponseDto(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler({ClientEmailNotUniqueException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handleClientNameNotUniqueException(Exception exception) {

    String message = "Error: Client name is already taken!";
    return new ErrorResponseDto(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler({PositionNotFoundException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handleNoPositionsFoundException(Exception exception) {

    String message = "Error: there are no positions with the given parameters!";
    return new ErrorResponseDto(HttpStatus.BAD_REQUEST, message);
  }

  @ExceptionHandler({InvalidPositionIdException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponseDto handleNoPositionsFoundByIdException(Exception exception) {

    String message = "Error: there are no positions with the provided Id!";
    return new ErrorResponseDto(HttpStatus.BAD_REQUEST, message);
  }


}
