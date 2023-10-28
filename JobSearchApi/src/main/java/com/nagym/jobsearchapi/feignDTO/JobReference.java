package com.nagym.jobsearchapi.feignDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class JobReference {
    private String landing_page;

    public JobReference() {
    }

    public JobReference(String landing_page) {
        this.landing_page = landing_page;
    }

    public String getLanding_page() {
        return landing_page;
    }

    public void setLanding_page(String landing_page) {
        this.landing_page = landing_page;
    }
}
