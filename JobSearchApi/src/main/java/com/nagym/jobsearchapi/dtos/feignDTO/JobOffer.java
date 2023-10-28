package com.nagym.jobsearchapi.dtos.feignDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobOffer {
    private String contents;
    private String name;
    private String type;
    private String publication_date;
    private String short_name;
    private String model_type;
    private Integer id;
    private List<JobLocation> locations;
    private List<JobCategory> categories;
    private List<JobLevel> levels;
    private JobReference refs;
    private Company company;
}
