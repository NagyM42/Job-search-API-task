package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.GetPositionDto;
import com.nagym.jobsearchapi.dtos.GetPositionResponseDto;
import com.nagym.jobsearchapi.feignDTO.JobSearchCriteria;
import com.nagym.jobsearchapi.feignDTO.Root;
import com.nagym.jobsearchapi.services.JobService;
import com.nagym.jobsearchapi.services.PositionServiceImpl;
import com.nagym.jobsearchapi.services.ValidatorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPositionController {

  PositionServiceImpl positionService;
  ValidatorService validatorService;

  JobService jobService;

  @Autowired
  public GetPositionController(PositionServiceImpl positionService,
      ValidatorService validatorService,
      JobService jobService) {
    this.positionService = positionService;
    this.validatorService = validatorService;
    this.jobService = jobService;
  }

  @GetMapping({("/positions")})
  public ResponseEntity<List<GetPositionResponseDto>> positionSearch(
      @RequestBody GetPositionDto getPositionDto) {

    validatorService.apiKeyValidation(getPositionDto.getUuid());
    validatorService.positionNameLengthValidation(getPositionDto.getPositionDescription());
    validatorService.positionNameLengthValidation(getPositionDto.getPositionLocation());

    List<GetPositionResponseDto> listofPositionsInDataBase = positionService.summarizePositionsFromDatabase(
        getPositionDto.getPositionDescription(),
        getPositionDto.getPositionLocation());

    return positionService.responseCreator(listofPositionsInDataBase);
  }


  @GetMapping({("/positions1")})
  public Root positionSearch2() {

    JobSearchCriteria jobSearchCriteria = new JobSearchCriteria("Product","London, United Kingdom",0);

    Root result = jobService.getJobs(jobSearchCriteria);
    if(result == null){
      return new Root();
    }

    return result;
  }



}
