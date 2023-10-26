package com.nagym.jobsearchapi.dtos;

import java.util.UUID;

public class PositionRegisterDto {

  private String positionDescription;
  private String positionLocation;
  private String jobURL;
  private UUID uuid;

  public PositionRegisterDto() {
  }

  public PositionRegisterDto(String positionDescription, String positionLocation, String jobURL,
      UUID uuid) {
    this.positionDescription = positionDescription;
    this.positionLocation = positionLocation;
    this.jobURL = jobURL;
    this.uuid = uuid;
  }

  public String getPositionDescription() {
    return positionDescription;
  }

  public void setPositionDescription(String positionDescription) {
    this.positionDescription = positionDescription;
  }

  public String getPositionLocation() {
    return positionLocation;
  }

  public void setPositionLocation(String positionLocation) {
    this.positionLocation = positionLocation;
  }

  public String getJobURL() {
    return jobURL;
  }

  public void setJobURL(String jobURL) {
    this.jobURL = jobURL;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
