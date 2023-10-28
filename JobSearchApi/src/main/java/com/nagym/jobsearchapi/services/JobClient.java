package com.nagym.jobsearchapi.services;

import com.nagym.jobsearchapi.feignDTO.JobOffer;
import com.nagym.jobsearchapi.feignDTO.Root;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "jobclient", url = "https://www.themuse.com/api/public/jobs")
public interface JobClient {
  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  Root getOffers(@RequestParam(name = "page") int page, @RequestParam(name = "category") String category, @RequestParam(name = "location") String location);

}
