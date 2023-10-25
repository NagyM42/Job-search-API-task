package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.ClientRegisterDTO;
import com.nagym.jobsearchapi.dtos.ClientResponseDTO;
import com.nagym.jobsearchapi.dtos.PositionResponseDto;
import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.services.ClientServiceImpl;
import com.nagym.jobsearchapi.services.JobService;
import com.nagym.jobsearchapi.services.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewJobController {

  private ValidatorService validatorService;
  private JobService jobService;

  @Autowired
  public NewJobController(ValidatorService validatorService, JobService jobService) {
    this.validatorService = validatorService;
    this.jobService = jobService;
  }

  @PostMapping({("/positions")})
  public ResponseEntity<PositionResponseDto> positionRegistration(@RequestBody  registerDTO){

    validatorService.clientNameValidation(registerDTO.getClientName());
    validatorService.clientEmailValidation(registerDTO.getEmail());

    ClientModel client = new ClientModel(registerDTO);
    client = clientService.saveClient(client);

    return ResponseEntity.ok(new ClientResponseDTO(client));
  }
}
