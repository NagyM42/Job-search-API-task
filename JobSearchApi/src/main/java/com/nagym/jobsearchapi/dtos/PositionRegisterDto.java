package com.nagym.jobsearchapi.dtos;

public class PositionRegisterDto {

  String jobDescription;
  String geographicalPosition;
  String jobURL;

  public PositionRegisterDto() {
  }

  public PositionRegisterDto(String jobDescription, String geographicalPosition, String jobURL) {
    this.jobDescription = jobDescription;
    this.geographicalPosition = geographicalPosition;
    this.jobURL = jobURL;
  }
}
