package com.nagym.jobsearchapi.dtos.feignDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private Integer companyId;
    private String shortName;
    private String name;
}
