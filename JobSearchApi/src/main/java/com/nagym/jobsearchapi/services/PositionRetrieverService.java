package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.dtos.GetPositionResponseDto;
import com.nagym.jobsearchapi.exceptions.PositionNotFoundException;
import com.nagym.jobsearchapi.feignDTO.JobSearchCriteria;
import com.nagym.jobsearchapi.feignDTO.Root;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PositionRetrieverService {

  JobService jobService;

  @Autowired
  public PositionRetrieverService(JobService jobService) {
    this.jobService = jobService;
  }

  public ResponseEntity<List<GetPositionResponseDto>> responseCreator(List<GetPositionResponseDto> databaseList, List<>) throws PositionNotFoundException {

    if(input.isEmpty()){
      throw new PositionNotFoundException();
    }
    return ResponseEntity.ok(input);
  }





}
