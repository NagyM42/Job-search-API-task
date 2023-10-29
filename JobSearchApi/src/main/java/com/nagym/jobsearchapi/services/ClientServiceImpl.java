package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.models.ClientModel;
import com.nagym.jobsearchapi.repositories.ClientRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  @Autowired
  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public ClientModel saveClient(ClientModel clientModel) {
    return clientRepository.save(clientModel);
  }

  public ClientModel getClientById(UUID clientID) {
    return clientRepository.findById(clientID).get();
  }

}
