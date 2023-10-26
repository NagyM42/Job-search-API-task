package com.nagym.jobsearchapi.repositories;

import com.nagym.jobsearchapi.models.PositionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<PositionModel,Long> {

}
