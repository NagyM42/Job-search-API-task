package com.nagym.jobsearchapi.feignclientmodels;

public class JobLocation {

  private String name;

  public JobLocation() {
  }

  public JobLocation(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
