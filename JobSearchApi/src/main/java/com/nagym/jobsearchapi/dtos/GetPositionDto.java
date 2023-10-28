package com.nagym.jobsearchapi.dtos;

import java.util.UUID;

public class GetPositionDto {

  private String positionDescription;
  private String positionLocation;
  private UUID uuid;

  public GetPositionDto() {
  }

  public GetPositionDto(String positionDescription, String positionLocation, UUID uuid) {
    this.positionDescription = positionDescription;
    this.positionLocation = positionLocation;
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

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
