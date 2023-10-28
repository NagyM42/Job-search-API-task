package com.nagym.jobsearchapi.controllers;

import com.nagym.jobsearchapi.dtos.PositionSearchDto;
import com.nagym.jobsearchapi.dtos.PositionSearchResponseDto;
import com.nagym.jobsearchapi.feignDTO.JobOffer;
import com.nagym.jobsearchapi.feignDTO.JobSearchCriteria;
import com.nagym.jobsearchapi.feignDTO.Root;
import com.nagym.jobsearchapi.services.JobService;
import com.nagym.jobsearchapi.services.PositionServiceImpl;
import com.nagym.jobsearchapi.services.ValidatorService;
import java.sql.ResultSet;
import java.util.List;
import jdk.jfr.consumer.RecordingStream;
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
  public ResponseEntity<List<PositionSearchResponseDto>> positionSearch(
      @RequestBody PositionSearchDto positionSearchDto) {

    validatorService.apiKeyValidation(positionSearchDto.getUuid());
    validatorService.positionNameLengthValidation(positionSearchDto.getPositionDescription());
    validatorService.positionNameLengthValidation(positionSearchDto.getPositionLocation());

    List<PositionSearchResponseDto> listofPositionsInDataBase = positionService.summarizePositionsFromDatabase(
        positionSearchDto.getPositionDescription(),
        positionSearchDto.getPositionLocation());

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
