package com.nagym.jobsearchapi.models;

import com.nagym.jobsearchapi.dtos.PositionRegisterDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PositionModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String positionName;
  @Column(nullable = false)
  private String positionGeographicalPosition;

  @Column
  private String positionURL;

  @ManyToOne
  private ClientModel ownerClient;

  public PositionModel() {
  }

  public PositionModel(String positionName, String jobGeographicalPosition, String positionURL) {
    this.positionName = positionName;
    this.positionGeographicalPosition = jobGeographicalPosition;
    this.positionURL = positionURL;
  }

  public PositionModel(PositionRegisterDto positionRegisterDto){
    this.positionName = positionRegisterDto.getPositionDescription();
    this.positionGeographicalPosition = positionRegisterDto.getPositionLocation();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  public String getPositionGeographicalPosition() {
    return positionGeographicalPosition;
  }

  public void setPositionGeographicalPosition(String positionGeographicalPosition) {
    this.positionGeographicalPosition = positionGeographicalPosition;
  }

  public String getPositionURL() {
    return positionURL;
  }

  public void setPositionURL(String positionURL) {
    this.positionURL = positionURL;
  }

  public ClientModel getOwnerClient() {
    return ownerClient;
  }

  public void setOwnerClient(ClientModel ownerClient) {
    this.ownerClient = ownerClient;
  }
}
