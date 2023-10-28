package com.nagym.jobsearchapi.feignDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class JobSearchCriteria {
    private String categoryName;
    private String locationName;
    private int page;


    public JobSearchCriteria() {
    }

    public JobSearchCriteria(String categoryName, String locationName, int page) {
        this.categoryName = categoryName;
        this.locationName = locationName;
        this.page = page;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
