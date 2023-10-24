package com.nagym.jobsearchapi.dtos;

public class ClientResponseDTO {

  String UUID;

  public ClientResponseDTO() {
  }

  public ClientResponseDTO(String UUID) {
    this.UUID = UUID;
  }

  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }
}
