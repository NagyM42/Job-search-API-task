package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.feignDTO.JobOffer;
import com.nagym.jobsearchapi.feignDTO.JobSearchCriteria;
import com.nagym.jobsearchapi.feignDTO.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    private final JobClient jobClient;


    @Autowired
    public JobService(JobClient jobClient) {
        this.jobClient = jobClient;
    }

    public Root getJobs(JobSearchCriteria criteria) {
        return jobClient.getOffers(criteria.getPage(), criteria.getCategoryName(),criteria.getLocationName());
    }
}
