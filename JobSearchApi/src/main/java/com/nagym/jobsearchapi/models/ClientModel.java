package com.nagym.jobsearchapi.models;

import com.nagym.jobsearchapi.dtos.ClientRegisterDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class ClientModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false)
  private String clientName;
  @Column(nullable = false)
  private String clientEmail;

  @OneToMany(mappedBy = "ownerClient")
  private List<PositionModel> jobs;

  public ClientModel() {
  }

  public ClientModel(UUID id, String clientName, String clientEmail) {
    this.id = id;
    this.clientName = clientName;
    this.clientEmail = clientEmail;
  }

  public ClientModel(ClientRegisterDTO registerDTO) {
    this.clientName = registerDTO.getClientName();
    this.clientEmail = registerDTO.getEmail();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
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
