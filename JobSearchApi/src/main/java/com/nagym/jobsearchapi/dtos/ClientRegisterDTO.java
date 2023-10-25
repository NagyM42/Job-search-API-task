package com.nagym.jobsearchapi.dtos;

public class ClientRegisterDTO {
  private String clientName;
  private String email;

  public ClientRegisterDTO() {
  }

  public ClientRegisterDTO(String clientName, String email) {
    this.clientName = clientName;
    this.email = email;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
