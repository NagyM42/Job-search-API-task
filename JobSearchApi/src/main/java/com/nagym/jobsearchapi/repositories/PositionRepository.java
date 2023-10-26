package com.nagym.jobsearchapi.repositories;

import com.nagym.jobsearchapi.models.PositionModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<PositionModel,Long> {
  Optional<List<PositionModel>> findAllByPositionGeographicalPositionContainingAndPositionNameContaining(String location,String name);
  boolean existsByPositionGeographicalPositionContainingAndPositionNameContaining(String location,String name);
}
