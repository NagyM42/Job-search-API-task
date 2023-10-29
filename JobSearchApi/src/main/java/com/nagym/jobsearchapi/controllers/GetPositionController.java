package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.GetPositionDto;
import com.nagym.jobsearchapi.dtos.GetPositionFromDatabaseDto;
import com.nagym.jobsearchapi.dtos.GetPositionFromMuseDto;
import com.nagym.jobsearchapi.dtos.GetPositionResponseDto;
import com.nagym.jobsearchapi.feignDTO.JobSearchCriteria;
import com.nagym.jobsearchapi.services.JobService;
import com.nagym.jobsearchapi.services.PositionRetrieverService;
import com.nagym.jobsearchapi.services.PositionServiceImpl;
import com.nagym.jobsearchapi.services.ValidatorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPositionController {

  PositionServiceImpl positionService;
  ValidatorService validatorService;
  PositionRetrieverService positionRetrieverService;
  JobService jobService;

  @Autowired
  public GetPositionController(PositionServiceImpl positionService,
      ValidatorService validatorService,
      PositionRetrieverService positionRetrieverService, JobService jobService) {
    this.positionService = positionService;
    this.validatorService = validatorService;
    this.positionRetrieverService = positionRetrieverService;
    this.jobService = jobService;
  }

  @GetMapping({("/positions")})
  public ResponseEntity<GetPositionResponseDto> getPositions(
      @RequestBody GetPositionDto getPositionDto) {

    validatorService.apiKeyValidation(getPositionDto.getUuid());
    validatorService.positionNameLengthValidation(getPositionDto.getPositionDescription());
    validatorService.positionNameLengthValidation(getPositionDto.getPositionLocation());

    List<GetPositionFromDatabaseDto> listofPositionsInDataBase = positionService.summarizePositionsFromDatabase(
        getPositionDto.getPositionDescription(),
        getPositionDto.getPositionLocation());

    JobSearchCriteria searchCriteria = new JobSearchCriteria(getPositionDto);
    List<GetPositionFromMuseDto> listOfPositionsInMuse = jobService.getPositionsFromMuse(
        searchCriteria);

    return positionRetrieverService.responseCreator(listofPositionsInDataBase,
        listOfPositionsInMuse);
  }

  @GetMapping({"/positions/{id}"})
  public GetPositionFromDatabaseDto getSinglePosition(@PathVariable(name = "id") Long id) {
    return new GetPositionFromDatabaseDto(positionService.findPositionFromDatabase(id));
  }

}
