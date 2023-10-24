package com.nagym.jobsearchapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewClientController {

  @PostMapping({("/clients")})
  public ResponseEntity clientRegistration(@RequestBody ){

  }

}
