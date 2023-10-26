package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.models.PositionModel;
import com.nagym.jobsearchapi.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

  PositionRepository positionRepository;
  ClientService clientService;

  @Autowired

  public PositionServiceImpl(PositionRepository positionRepository, ClientService clientService) {
    this.positionRepository = positionRepository;
    this.clientService = clientService;
  }

  public PositionModel savePosition(PositionModel positionModel) {
    return positionRepository.save(positionModel);
  }


  public void savePositionWithClient(PositionModel positionModel, ClientModel clientModel) {

    PositionModel positionWithId = savePosition(positionModel);
    positionWithId.setOwnerClient(clientModel);
    savePosition(positionWithId);
  }
}
