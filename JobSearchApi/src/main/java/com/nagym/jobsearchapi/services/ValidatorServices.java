package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.exceptions.InvalidClientEmailException;
import com.nagym.jobsearchapi.exceptions.InvalidClientNameException;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServices {

  public void clientNameValidation(String clientName)  throws InvalidClientNameException {

    if(clientName.length() > 100){
      throw new InvalidClientNameException("Invalid name: Client name extends 100 charcters!");
    }
  }

  public void clientEmailValidation(String clientEmail) throws InvalidClientEmailException {

    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    if (!Pattern.compile(regexPattern).matcher(clientEmail).matches()){
      throw new InvalidClientEmailException("Error: Invalid e-mail address format.");
    }
  }
}
