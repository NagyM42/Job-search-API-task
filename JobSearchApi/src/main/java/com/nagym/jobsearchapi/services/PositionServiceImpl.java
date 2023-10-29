package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.dtos.GetPositionFromDatabaseDto;
import com.nagym.jobsearchapi.exceptions.InvalidPositionIdException;
import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.models.PositionModel;
import com.nagym.jobsearchapi.repositories.PositionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

  public PositionModel findPositionFromDatabase(Long id) throws InvalidPositionIdException {
    if (!positionRepository.existsById(id)) {
      throw new InvalidPositionIdException();
    }
    return positionRepository.findById(id).get();
  }

  protected void setURLforPositionModel(PositionModel positionModelWithId) {
    positionModelWithId.setPositionURL(
        "http://localhost:8080/positions/" + positionModelWithId.getId());
  }


  public PositionModel savePositionWithClient(PositionModel positionModel,
      ClientModel clientModel) {
    PositionModel positionWithId = savePosition(positionModel);
    positionWithId.setOwnerClient(clientModel);
    setURLforPositionModel(positionWithId);
    return savePosition(positionWithId);
  }

  protected Optional<List<PositionModel>> searchPositions(String positionName,
      String positionLocation) {
    return positionRepository.findAllByPositionGeographicalPositionContainingAndPositionNameContaining(
        positionLocation, positionName);
  }

  protected boolean positionFound(String positionName, String positionLocation) {
    return positionRepository.existsByPositionGeographicalPositionContainingAndPositionNameContaining(
        positionLocation, positionName);
  }

  public List<GetPositionFromDatabaseDto> summarizePositionsFromDatabase(String positionName,
      String positionLocation) {

    if (positionFound(positionName, positionLocation)) {
      return searchPositions(positionName, positionLocation).get().stream().map(
          GetPositionFromDatabaseDto::new).collect(
          Collectors.toList());
    } else {
      return new ArrayList<>();
    }
  }
}
