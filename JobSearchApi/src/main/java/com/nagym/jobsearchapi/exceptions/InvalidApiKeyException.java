package com.nagym.jobsearchapi.exceptions;

public class InvalidApiKeyException extends RuntimeException{

  public InvalidApiKeyException(String message) {
    super(message);
  }
}
