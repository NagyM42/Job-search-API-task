package com.nagym.jobsearchapi.dtos;

public class JobRegisterDto {

  String jobDescription;
  String geographicalPosition;
  String jobURL;

  public JobRegisterDto() {
  }

  public JobRegisterDto(String jobDescription, String geographicalPosition, String jobURL) {
    this.jobDescription = jobDescription;
    this.geographicalPosition = geographicalPosition;
    this.jobURL = jobURL;
  }
}
