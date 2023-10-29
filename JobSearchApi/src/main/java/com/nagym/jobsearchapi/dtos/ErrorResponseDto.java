package com.nagym.jobsearchapi.dtos;

import org.springframework.http.HttpStatus;

public class ErrorResponseDto {

  private String status;
  private String message;

  public ErrorResponseDto(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public ErrorResponseDto(HttpStatus httpStatus, String message) {
    this.status = getResponseStatus(httpStatus);
    this.message = message;
  }

  public String getResponseStatus(HttpStatus status) {
    String message = status.value() + " - " + status.getReasonPhrase();
    return message;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
