package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.ClientRegisterDTO;
import com.nagym.jobsearchapi.dtos.ClientResponseDTO;
import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.services.ClientServiceImpl;
import com.nagym.jobsearchapi.services.ValidatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewClientController {

  private ValidatorServices validatorServices;
  private ClientServiceImpl clientService;

  @Autowired

  public NewClientController(ValidatorServices validatorServices, ClientServiceImpl clientService) {
    this.validatorServices = validatorServices;
    this.clientService = clientService;
  }

  @PostMapping({("/clients")})
  public ResponseEntity<ClientResponseDTO> clientRegistration(@RequestBody ClientRegisterDTO registerDTO){

    validatorServices.clientNameValidation(registerDTO.getClientName());
    validatorServices.clientEmailValidation(registerDTO.getEmail());

    ClientModel client = new ClientModel(registerDTO);
    client = clientService.saveClient(client);

    return ResponseEntity.ok(new ClientResponseDTO(client));
  }
}
