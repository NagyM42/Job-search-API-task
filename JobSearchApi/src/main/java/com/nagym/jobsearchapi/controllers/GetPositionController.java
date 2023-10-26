package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.ClientRegisterDTO;
import com.nagym.jobsearchapi.dtos.ClientResponseDTO;
import com.nagym.jobsearchapi.dtos.PositionSearchDto;
import com.nagym.jobsearchapi.dtos.PositionSearchResponseDto;
import com.nagym.jobsearchapi.services.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPositionController {

  ValidatorService validatorService;

  @Autowired
  public GetPositionController(ValidatorService validatorService) {
    this.validatorService = validatorService;
  }

  @GetMapping({("/positions")})
  public ResponseEntity<PositionSearchResponseDto> positionSearch(@RequestBody PositionSearchDto positionSearchDto){

    validatorService.apiKeyValidation(positionSearchDto.getUuid());
    validatorService.positionNameLengthValidation(positionSearchDto.getPositionDescription());
    validatorService.positionNameLengthValidation(positionSearchDto.getPositionLocation());



  }

}
