package com.nagym.jobsearchapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class JobModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String jobName;
  @Column(nullable = false)
  private String jobGeographicalPosition;

  @Column(nullable = false)
  private String jobURL;

  @ManyToOne
  private ClientModel ownerClient;

  public JobModel() {
  }

  public JobModel(Long id, String jobName, String jobGeographicalPosition, String jobURL) {
    this.id = id;
    this.jobName = jobName;
    this.jobGeographicalPosition = jobGeographicalPosition;
    this.jobURL = jobURL;
  }
}
