package com.nagym.jobsearchapi.feignclientmodels;

import com.nagym.jobsearchapi.dtos.GetPositionDto;


public class JobSearchCriteria {

  private String categoryName;
  private String locationName;
  private final int page = 0;


  public JobSearchCriteria() {
  }

  public JobSearchCriteria(String categoryName, String locationName) {
    this.categoryName = categoryName;
    this.locationName = locationName;
  }

  public JobSearchCriteria(GetPositionDto getPositionDto) {
    this.categoryName = getPositionDto.getPositionDescription();
    this.locationName = getPositionDto.getPositionLocation();
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public int getPage() {
    return page;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
