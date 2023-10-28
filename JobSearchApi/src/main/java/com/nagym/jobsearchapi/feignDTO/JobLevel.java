package com.nagym.jobsearchapi.feignDTO;

public class JobLevel {

  String name;
  String short_name;

  public JobLevel() {
  }

  public JobLevel(String name, String short_name) {
    this.name = name;
    this.short_name = short_name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShort_name() {
    return short_name;
  }

  public void setShort_name(String short_name) {
    this.short_name = short_name;
  }
}
