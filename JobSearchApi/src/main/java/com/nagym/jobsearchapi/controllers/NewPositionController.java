package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.ClientResponseDTO;
import com.nagym.jobsearchapi.dtos.PositionRegisterDto;
import com.nagym.jobsearchapi.dtos.PositionResponseDto;
import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.models.PositionModel;
import com.nagym.jobsearchapi.services.JobService;
import com.nagym.jobsearchapi.services.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewPositionController {

  private ValidatorService validatorService;
  private JobService jobService;

  @Autowired
  public NewPositionController(ValidatorService validatorService, JobService jobService) {
    this.validatorService = validatorService;
    this.jobService = jobService;
  }

  @PostMapping({("/positions")})
  public ResponseEntity<PositionResponseDto> positionRegistration(@RequestBody PositionRegisterDto positionRegisterDto){

    validatorService.lengthValidation(positionRegisterDto.getPositionDescription(), 50, "position description");
    validatorService.lengthValidation(positionRegisterDto.getGeographicalPosition(), 50, "geographical position");
    PositionModel position = new ;
    client = clientService.saveClient(client);

    return ResponseEntity.ok(new ClientResponseDTO(client));
  }
}
