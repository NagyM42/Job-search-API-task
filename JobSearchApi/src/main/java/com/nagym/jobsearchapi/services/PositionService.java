package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.dtos.GetPositionFromDatabaseDto;
import com.nagym.jobsearchapi.exceptions.InvalidPositionIdException;
import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.models.PositionModel;
import java.util.List;

public interface PositionService {

  PositionModel savePosition(PositionModel positionModel);

  PositionModel findPositionFromDatabase(Long id) throws InvalidPositionIdException;

  PositionModel savePositionWithClient(PositionModel positionModel,
      ClientModel clientModel);

  List<GetPositionFromDatabaseDto> summarizePositionsFromDatabase(String positionName,
      String positionLocation);
}
