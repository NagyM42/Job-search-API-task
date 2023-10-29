package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.exceptions.ClientEmailNotUniqueException;
import com.nagym.jobsearchapi.exceptions.InvalidApiKeyException;
import com.nagym.jobsearchapi.exceptions.InvalidClientEmailException;
import com.nagym.jobsearchapi.exceptions.InvalidClientNameLengthException;
import com.nagym.jobsearchapi.exceptions.InvalidPositionLocationLengthException;
import com.nagym.jobsearchapi.exceptions.InvalidPositionNameLegthException;
import com.nagym.jobsearchapi.repositories.ClientRepository;
import java.util.UUID;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServiceImpl implements ValidatorService {

  ClientRepository clientRepository;

  @Autowired
  public ValidatorServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public void clientNameValidation(String clientName) throws InvalidClientNameLengthException {

    if (clientName.length() > 100) {
      throw new InvalidClientNameLengthException(
          "Invalid name: Client name extends 100 characters!");
    }
  }

  public void positionNameLengthValidation(String postName)
      throws InvalidPositionNameLegthException {

    if (postName.length() > 50) {
      throw new InvalidPositionNameLegthException();
    }
  }

  public void positionLocationLengthValidation(String postLocation)
      throws InvalidPositionLocationLengthException {
    if (postLocation.length() > 50) {
      throw new InvalidPositionLocationLengthException();
    }
  }

  public void clientEmailFormatValidation(String clientEmail) throws InvalidClientEmailException {

    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    if (!Pattern.compile(regexPattern).matcher(clientEmail).matches()) {
      throw new InvalidClientEmailException();
    }
  }

  public void clientEmailUniquenessValidation(String clientEmail)
      throws ClientEmailNotUniqueException {
    if (clientRepository.existsByClientEmail(clientEmail)) {
      throw new ClientEmailNotUniqueException();
    }
  }

  public void apiKeyValidation(UUID clientId) throws InvalidApiKeyException {

    if (!clientRepository.existsById(clientId)) {
      throw new InvalidApiKeyException();
    }
  }
}
