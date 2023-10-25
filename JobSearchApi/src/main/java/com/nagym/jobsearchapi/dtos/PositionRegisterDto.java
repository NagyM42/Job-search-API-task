package com.nagym.jobsearchapi.dtos;

public class PositionRegisterDto {

  private String positionDescription;
  private String geographicalPosition;
  private String jobURL;

  public PositionRegisterDto() {
  }

  public PositionRegisterDto(String jobDescription, String geographicalPosition, String jobURL) {
    this.positionDescription = jobDescription;
    this.geographicalPosition = geographicalPosition;
    this.jobURL = jobURL;
  }

  public String getPositionDescription() {
    return positionDescription;
  }

  public void setPositionDescription(String positionDescription) {
    this.positionDescription = positionDescription;
  }

  public String getGeographicalPosition() {
    return geographicalPosition;
  }

  public void setGeographicalPosition(String geographicalPosition) {
    this.geographicalPosition = geographicalPosition;
  }

  public String getJobURL() {
    return jobURL;
  }

  public void setJobURL(String jobURL) {
    this.jobURL = jobURL;
  }
}
