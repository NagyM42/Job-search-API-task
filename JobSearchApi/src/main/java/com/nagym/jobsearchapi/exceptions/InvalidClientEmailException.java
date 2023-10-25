package com.nagym.jobsearchapi.exceptions;

public class InvalidClientEmailException extends RuntimeException{

  public InvalidClientEmailException(String message) {
    super(message);
  }
}
