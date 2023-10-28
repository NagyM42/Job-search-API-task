package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.ClientRegisterDTO;
import com.nagym.jobsearchapi.dtos.ClientResponseDTO;
import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.services.ClientServiceImpl;
import com.nagym.jobsearchapi.services.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewClientController {

  private ValidatorService validatorService;
  private ClientServiceImpl clientService;

  @Autowired

  public NewClientController(ValidatorService validatorService, ClientServiceImpl clientService) {
    this.validatorService = validatorService;
    this.clientService = clientService;
  }

  @PostMapping({("/clients")})
  public ResponseEntity<ClientResponseDTO> clientRegistration(@RequestBody ClientRegisterDTO registerDTO){

    validatorService.clientEmailUniquenessValidation(registerDTO.getEmail());
    validatorService.clientNameValidation(registerDTO.getClientName());
    validatorService.clientEmailFormatValidation(registerDTO.getEmail());

    ClientModel client = new ClientModel(registerDTO);
    client = clientService.saveClient(client);

    return ResponseEntity.ok(new ClientResponseDTO(client));
  }
}
