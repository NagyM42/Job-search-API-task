package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.dtos.GetPositionFromMuseDto;
import com.nagym.jobsearchapi.dtos.GetPositionFromDatabaseDto;
import com.nagym.jobsearchapi.dtos.GetPositionResponseDto;
import com.nagym.jobsearchapi.exceptions.PositionNotFoundException;
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

  public ResponseEntity<GetPositionResponseDto> responseCreator(List<GetPositionFromDatabaseDto> databaseList, List<GetPositionFromMuseDto> museList) throws PositionNotFoundException {
    if(databaseList.isEmpty() && museList.isEmpty()){
      throw new PositionNotFoundException();
    }
    GetPositionResponseDto clientResponse = new GetPositionResponseDto(databaseList, museList);
    return ResponseEntity.ok(clientResponse);
  }
}
