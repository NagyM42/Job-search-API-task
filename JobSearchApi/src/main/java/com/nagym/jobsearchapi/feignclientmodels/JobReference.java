package com.nagym.jobsearchapi.feignclientmodels;

public class JobReference {

  private String landing_page;

  public JobReference() {
  }

  public JobReference(String landing_page) {
    this.landing_page = landing_page;
  }

  public String getLanding_page() {
    return landing_page;
  }

  public void setLanding_page(String landing_page) {
    this.landing_page = landing_page;
  }
}
