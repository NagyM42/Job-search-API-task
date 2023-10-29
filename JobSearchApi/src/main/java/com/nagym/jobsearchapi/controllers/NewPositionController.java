package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.PositionRegisterDto;
import com.nagym.jobsearchapi.dtos.PositionResponseDto;
import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.models.PositionModel;
import com.nagym.jobsearchapi.services.ClientServiceImpl;
import com.nagym.jobsearchapi.services.PositionServiceImpl;
import com.nagym.jobsearchapi.services.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewPositionController {

  private ValidatorService validatorService;
  private PositionServiceImpl positionService;
  private ClientServiceImpl clientService;

  @Autowired
  public NewPositionController(ValidatorService validatorService,
      PositionServiceImpl positionService,
      ClientServiceImpl clientService) {
    this.validatorService = validatorService;
    this.positionService = positionService;
    this.clientService = clientService;
  }

  @PostMapping({("/positions")})
  public ResponseEntity<PositionResponseDto> positionRegistration(
      @RequestBody PositionRegisterDto positionRegisterDto) {

    validatorService.apiKeyValidation(positionRegisterDto.getUuid());
    validatorService.positionNameLengthValidation(positionRegisterDto.getPositionDescription());
    validatorService.positionLocationLengthValidation(positionRegisterDto.getPositionLocation());

    PositionModel position = new PositionModel(positionRegisterDto);

    ClientModel client = clientService.getClientById(positionRegisterDto.getUuid());
    position = positionService.savePositionWithClient(position, client);

    return ResponseEntity.ok(new PositionResponseDto(position.getPositionURL()));
  }
}
