package com.ifdevs.ace.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

  @RequestMapping("/")
  public String home() {
    return "Hello World!";
  }
}
