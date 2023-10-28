package com.nagym.jobsearchapi.dtos;

import com.nagym.jobsearchapi.models.PositionModel;

public class GetPositionResponseDto {
  private String positionName;
  private String positionLocation;
  private String positionURL;

  public GetPositionResponseDto() {
  }

  public GetPositionResponseDto(String positionName, String positionLocation,
      String positionURL) {
    this.positionName = positionName;
    this.positionLocation = positionLocation;
    this.positionURL = positionURL;
  }

  public GetPositionResponseDto(PositionModel positionModel){
    this.positionName = positionModel.getPositionName();
    this.positionLocation = positionModel.getPositionGeographicalPosition();
    this.positionURL = positionModel.getPositionURL();
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  public String getPositionLocation() {
    return positionLocation;
  }

  public void setPositionLocation(String positionLocation) {
    this.positionLocation = positionLocation;
  }

  public String getPositionURL() {
    return positionURL;
  }

  public void setPositionURL(String positionURL) {
    this.positionURL = positionURL;
  }
}
