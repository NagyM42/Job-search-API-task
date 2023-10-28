package com.nagym.jobsearchapi.feignDTO;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<Object> tags;
    private JobReference refs;
    private Company company;

    public JobOffer() {
    }



    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getModel_type() {
        return model_type;
    }

    public void setModel_type(String model_type) {
        this.model_type = model_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<JobLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<JobLocation> locations) {
        this.locations = locations;
    }

    public List<JobCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<JobCategory> categories) {
        this.categories = categories;
    }

    public List<JobLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<JobLevel> levels) {
        this.levels = levels;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public JobReference getRefs() {
        return refs;
    }

    public void setRefs(JobReference refs) {
        this.refs = refs;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
