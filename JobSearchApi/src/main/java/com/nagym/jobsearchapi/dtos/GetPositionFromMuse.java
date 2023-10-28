package com.nagym.jobsearchapi.dtos;

import com.nagym.jobsearchapi.feignDTO.JobLocation;
import com.nagym.jobsearchapi.feignDTO.JobOffer;
import java.util.List;
import java.util.stream.Collectors;

public class GetPositionFromMuse extends GetPositionResponseDto{

  private String positionName;
  private List<String> positionLocations;
  private String positionURL;

  public GetPositionFromMuse() {
  }
  public GetPositionFromMuse(String positionName, List<String> positionLocations,
      String positionURL) {
    this.positionName = positionName;
    this.positionLocations = positionLocations;
    this.positionURL = positionURL;
  }


  public GetPositionFromMuse(JobOffer jobOffer){
    this.positionName = jobOffer.getName();
    this.positionLocations = jobOffer.getLocations().stream().map(JobLocation::getName).collect(
        Collectors.toList());
    this.positionURL = jobOffer.getRefs().getLanding_page();
  }
  @Override
  public String getPositionName() {
    return positionName;
  }

  @Override
  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }


  @Override
  public String getPositionURL() {
    return positionURL;
  }

  @Override
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
