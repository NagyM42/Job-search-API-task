package com.nagym.jobsearchapi.repositories;

import com.nagym.jobsearchapi.models.ClientModel;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientModel, UUID> {

}
