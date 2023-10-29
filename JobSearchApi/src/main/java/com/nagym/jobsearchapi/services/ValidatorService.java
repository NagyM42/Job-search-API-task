package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.exceptions.ClientEmailNotUniqueException;
import com.nagym.jobsearchapi.exceptions.InvalidApiKeyException;
import com.nagym.jobsearchapi.exceptions.InvalidClientEmailException;
import com.nagym.jobsearchapi.exceptions.InvalidClientNameLengthException;
import com.nagym.jobsearchapi.exceptions.InvalidPositionLocationLengthException;
import com.nagym.jobsearchapi.exceptions.InvalidPositionNameLegthException;
import java.util.UUID;

public interface ValidatorService {

  public void clientNameValidation(String clientName) throws InvalidClientNameLengthException;

  public void positionNameLengthValidation(String postName)
      throws InvalidPositionNameLegthException;

  public void positionLocationLengthValidation(String postLocation)
      throws InvalidPositionLocationLengthException;

  public void clientEmailFormatValidation(String clientEmail) throws InvalidClientEmailException;

  public void clientEmailUniquenessValidation(String clientEmail)
      throws ClientEmailNotUniqueException;

  public void apiKeyValidation(UUID clientId) throws InvalidApiKeyException;
}
