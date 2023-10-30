package com.nagym.jobsearchapi.feignclientmodels;

public class JobCategory {

  private String name;

  public JobCategory() {
  }

  public JobCategory(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
