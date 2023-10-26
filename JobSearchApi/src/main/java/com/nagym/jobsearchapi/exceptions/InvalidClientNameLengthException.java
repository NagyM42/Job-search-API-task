package com.nagym.jobsearchapi.exceptions;

public class InvalidClientNameLengthException extends RuntimeException{

  public InvalidClientNameLengthException(String message) {
    super(message);
  }
}
