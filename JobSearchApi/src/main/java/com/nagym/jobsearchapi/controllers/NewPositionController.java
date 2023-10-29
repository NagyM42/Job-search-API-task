package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.PositionRegisterDto;
import com.nagym.jobsearchapi.dtos.PositionResponseDto;
import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.models.PositionModel;
import com.nagym.jobsearchapi.services.ClientService;
import com.nagym.jobsearchapi.services.PositionService;
import com.nagym.jobsearchapi.services.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewPositionController {

  private ValidatorService validatorServiceImpl;
  private PositionService positionService;
  private ClientService clientService;

  @Autowired
  public NewPositionController(ValidatorService validatorServiceImpl,
      PositionService positionService,
      ClientService clientService) {
    this.validatorServiceImpl = validatorServiceImpl;
    this.positionService = positionService;
    this.clientService = clientService;
  }

  @PostMapping({("/positions")})
  public ResponseEntity<PositionResponseDto> positionRegistration(
      @RequestBody PositionRegisterDto positionRegisterDto) {

    validatorServiceImpl.apiKeyValidation(positionRegisterDto.getUuid());
    validatorServiceImpl.positionNameLengthValidation(positionRegisterDto.getPositionDescription());
    validatorServiceImpl.positionLocationLengthValidation(
        positionRegisterDto.getPositionLocation());

    PositionModel position = new PositionModel(positionRegisterDto);

    ClientModel client = clientService.getClientById(positionRegisterDto.getUuid());
    position = positionService.savePositionWithClient(position, client);

    return ResponseEntity.ok(new PositionResponseDto(position.getPositionURL()));
  }
}
