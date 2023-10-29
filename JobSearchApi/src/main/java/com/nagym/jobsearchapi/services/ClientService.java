package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.models.ClientModel;
import java.util.UUID;

public interface ClientService {

  public ClientModel saveClient(ClientModel clientModel);

  public ClientModel getClientById(UUID clientID);

}
