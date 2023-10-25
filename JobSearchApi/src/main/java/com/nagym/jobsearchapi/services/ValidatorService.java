package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.exceptions.InvalidApiKeyException;
import com.nagym.jobsearchapi.exceptions.InvalidClientEmailException;
import com.nagym.jobsearchapi.exceptions.InvalidLengthException;
import com.nagym.jobsearchapi.repositories.ClientRepository;
import java.util.UUID;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

  ClientRepository clientRepository;

  @Autowired
  public ValidatorService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public void clientNameValidation(String clientName) throws InvalidLengthException {

    if(clientName.length() > 100){
      throw new InvalidLengthException("Invalid name: Client name extends 100 charcters!");
    }
  }

  public void lengthValidation(String inputString, int maxLength,String fieldName) throws InvalidLengthException {

    if(inputString.length() > maxLength){
      throw new InvalidLengthException("Invalid " + fieldName + ": paramter exceeds " + maxLength + " characters!" );
    }
  }

  public void clientEmailValidation(String clientEmail) throws InvalidClientEmailException {

    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    if (!Pattern.compile(regexPattern).matcher(clientEmail).matches()){
      throw new InvalidClientEmailException("Error: Invalid e-mail address format.");
    }
  }

  public void apiKeyValidation(UUID clientId){

    if(!clientRepository.existsById(clientId)){
      throw new InvalidApiKeyException("Error: invalid API key provided!");
    }
  }
}
