package com.yechangqing.demo.java.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

  @RequestMapping("/metrics")
  public String forward() {
    return "forward:/actuator/health";
  }

}
