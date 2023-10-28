package com.nagym.jobsearchapi.feignDTO;

import java.io.Serializable;
import java.util.List;

public class Root  {

  public int page;
  public int page_count;
  public int items_per_page;
  public int took;
  public boolean timed_out;
  public int total;
  public List<JobOffer> results;
  public Object aggregations;

  public Root() {
  }

  public Root(int page, int page_count, int items_per_page, int took, boolean timed_out, int total,
      List<JobOffer> results, Aggregations aggregations) {
    this.page = page;
    this.page_count = page_count;
    this.items_per_page = items_per_page;
    this.took = took;
    this.timed_out = timed_out;
    this.total = total;
    this.results = results;
    this.aggregations = aggregations;
  }

  public Root(int page, int page_count, int items_per_page, int took, boolean timed_out, int total,
      List<JobOffer> results, Object aggregations) {
    this.page = page;
    this.page_count = page_count;
    this.items_per_page = items_per_page;
    this.took = took;
    this.timed_out = timed_out;
    this.total = total;
    this.results = results;
    this.aggregations = aggregations;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPage_count() {
    return page_count;
  }

  public void setPage_count(int page_count) {
    this.page_count = page_count;
  }

  public int getItems_per_page() {
    return items_per_page;
  }

  public void setItems_per_page(int items_per_page) {
    this.items_per_page = items_per_page;
  }

  public int getTook() {
    return took;
  }

  public void setTook(int took) {
    this.took = took;
  }

  public boolean isTimed_out() {
    return timed_out;
  }

  public void setTimed_out(boolean timed_out) {
    this.timed_out = timed_out;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<JobOffer> getResults() {
    return results;
  }

  public void setResults(List<JobOffer> results) {
    this.results = results;
  }

  public Object getAggregations() {
    return aggregations;
  }

  public void setAggregations(Object aggregations) {
    this.aggregations = aggregations;
  }
}
