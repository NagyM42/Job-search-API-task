package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.ClientRegisterDTO;
import com.nagym.jobsearchapi.dtos.ClientResponseDTO;
import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.services.ClientService;
import com.nagym.jobsearchapi.services.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewClientController {

  private ValidatorService validatorServiceImpl;
  private ClientService clientService;

  @Autowired
  public NewClientController(ValidatorService validatorServiceImpl, ClientService clientService) {
    this.validatorServiceImpl = validatorServiceImpl;
    this.clientService = clientService;
  }

  @PostMapping({("/clients")})
  public ResponseEntity<ClientResponseDTO> clientRegistration(
      @RequestBody ClientRegisterDTO registerDTO) {

    validatorServiceImpl.clientEmailUniquenessValidation(registerDTO.getEmail());
    validatorServiceImpl.clientNameValidation(registerDTO.getClientName());
    validatorServiceImpl.clientEmailFormatValidation(registerDTO.getEmail());

    ClientModel client = new ClientModel(registerDTO);
    client = clientService.saveClient(client);

    return ResponseEntity.ok(new ClientResponseDTO(client));
  }
}
