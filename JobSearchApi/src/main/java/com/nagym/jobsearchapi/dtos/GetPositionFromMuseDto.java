package com.nagym.jobsearchapi.dtos;

import com.nagym.jobsearchapi.feignDTO.JobLocation;
import com.nagym.jobsearchapi.feignDTO.JobOffer;
import java.util.List;
import java.util.stream.Collectors;

public class GetPositionFromMuseDto {

  private String positionName;
  private List<String> positionLocations;
  private String positionURL;

  public GetPositionFromMuseDto() {
  }

  public GetPositionFromMuseDto(String positionName, List<String> positionLocations,
      String positionURL) {
    this.positionName = positionName;
    this.positionLocations = positionLocations;
    this.positionURL = positionURL;
  }


  public GetPositionFromMuseDto(JobOffer jobOffer) {
    this.positionName = jobOffer.getName();
    this.positionLocations = jobOffer.getLocations().stream().map(JobLocation::getName).collect(
        Collectors.toList());
    this.positionURL = jobOffer.getRefs().getLanding_page();
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  public String getPositionURL() {
    return positionURL;
  }

  public void setPositionURL(String positionURL) {
    this.positionURL = positionURL;
  }

  public List<String> getPositionLocations() {
    return positionLocations;
  }

  public void setPositionLocations(List<String> positionLocations) {
    this.positionLocations = positionLocations;
  }

}
