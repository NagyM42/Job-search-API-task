package com.nagym.jobsearchapi.dtos;

public class PositionResponseDto {

  private String URL;

  public PositionResponseDto(String URL) {
    this.URL = URL;
  }

  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }
}
