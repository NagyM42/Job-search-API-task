package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.ClientRegisterDTO;
import com.nagym.jobsearchapi.dtos.ClientResponseDTO;
import com.nagym.jobsearchapi.dtos.PositionSearchDto;
import com.nagym.jobsearchapi.dtos.PositionSearchResponseDto;
import com.nagym.jobsearchapi.services.PositionServiceImpl;
import com.nagym.jobsearchapi.services.ValidatorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPositionController {

  PositionServiceImpl positionService;
  ValidatorService validatorService;


  @Autowired
  public GetPositionController(PositionServiceImpl positionService,
      ValidatorService validatorService) {
    this.positionService = positionService;
    this.validatorService = validatorService;
  }

  @GetMapping({("/positions")})
  public ResponseEntity<List<PositionSearchResponseDto>> positionSearch(
      @RequestBody PositionSearchDto positionSearchDto) {

    validatorService.apiKeyValidation(positionSearchDto.getUuid());
    validatorService.positionNameLengthValidation(positionSearchDto.getPositionDescription());
    validatorService.positionNameLengthValidation(positionSearchDto.getPositionLocation());

    List<PositionSearchResponseDto> output = positionService.summarizePositionsFromDatabase(
        positionSearchDto.getPositionDescription(),
        positionSearchDto.getPositionLocation());

    return ResponseEntity.ok(output);

  }

}
