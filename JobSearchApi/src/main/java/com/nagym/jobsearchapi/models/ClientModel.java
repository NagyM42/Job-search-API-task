package com.nagym.jobsearchapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class ClientModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private Long id;

  @Column(nullable = false)
  private String clientName;
  @Column(nullable = false)
  private String clientEmail;

  @OneToMany(mappedBy = "ownerClient")
  private List<JobModel> jobs;

  public ClientModel() {
  }

  public ClientModel(Long id, String clientName, String clientEmail) {
    this.id = id;
    this.clientName = clientName;
    this.clientEmail = clientEmail;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getClientEmail() {
    return clientEmail;
  }

  public void setClientEmail(String clientEmail) {
    this.clientEmail = clientEmail;
  }
}
