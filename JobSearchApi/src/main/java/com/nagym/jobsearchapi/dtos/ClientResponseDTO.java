package com.nagym.jobsearchapi.dtos;

import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.models.JobModel;

public class ClientResponseDTO {

  String UUID;

  public ClientResponseDTO() {
  }

  public ClientResponseDTO(String UUID) {
    this.UUID = UUID;
  }

  public ClientResponseDTO(ClientModel clientModel) {
    this.UUID = String.valueOf(clientModel.getId());
  }

  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }
}
