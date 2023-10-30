package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.dtos.GetPositionFromMuseDto;
import com.nagym.jobsearchapi.feignclientmodels.JobSearchCriteria;
import com.nagym.jobsearchapi.feignclientmodels.Root;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

  private final JobClient jobClient;

  @Autowired
  public JobService(JobClient jobClient) {
    this.jobClient = jobClient;
  }

  protected Root getJobs(JobSearchCriteria criteria) {
    return jobClient.getOffers(criteria.getPage(), criteria.getCategoryName(),
        criteria.getLocationName());
  }

  protected List<GetPositionFromMuseDto> extractPositionsFromMuse(Root root) {
    return root.getResults().stream().map(GetPositionFromMuseDto::new).toList();
  }

  public List<GetPositionFromMuseDto> getPositionsFromMuse(JobSearchCriteria criteria) {
    return extractPositionsFromMuse(getJobs(criteria));
  }
}
