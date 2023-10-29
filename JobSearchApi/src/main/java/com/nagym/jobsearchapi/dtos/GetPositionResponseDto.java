package com.nagym.jobsearchapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GetPositionResponseDto {

  private List<GetPositionFromDatabaseDto> getPositionFromDatabaseDtoList;
  private List<GetPositionFromMuseDto> getPositionFromMuseDtoList;

  public GetPositionResponseDto() {
  }

  public GetPositionResponseDto(List<GetPositionFromDatabaseDto> getPositionFromDatabaseDtoList,
      List<GetPositionFromMuseDto> getPositionFromMuseDtoList) {
    this.getPositionFromDatabaseDtoList = getPositionFromDatabaseDtoList;
    this.getPositionFromMuseDtoList = getPositionFromMuseDtoList;
  }


  @JsonProperty("Positions from the Database")
  public List<GetPositionFromDatabaseDto> getGetPositionDatabaseDtoList() {
    return getPositionFromDatabaseDtoList;
  }

  public void setGetPositionDatabaseDtoList(
      List<GetPositionFromDatabaseDto> getPositionFromDatabaseDtoList) {
    this.getPositionFromDatabaseDtoList = getPositionFromDatabaseDtoList;
  }
  @JsonProperty("Positions from Muse database")
  public List<GetPositionFromMuseDto> getGetPositionFromMuseDtoList() {
    return getPositionFromMuseDtoList;
  }

  public void setGetPositionFromMuseDtoList(
      List<GetPositionFromMuseDto> getPositionFromMuseDtoList) {
    this.getPositionFromMuseDtoList = getPositionFromMuseDtoList;
  }
}
