package com.antonio.course.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController {

  @GetMapping("/app")
  public String index() {
    return "Hello World";
  }
}
