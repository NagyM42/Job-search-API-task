package com.nagym.jobsearchapi.dtos;

public class ClientRegisterDTO {
  String clientName;
  String email;

  public ClientRegisterDTO() {
  }

  public ClientRegisterDTO(String clientName, String email) {
    this.clientName = clientName;
    this.email = email;
  }
}
