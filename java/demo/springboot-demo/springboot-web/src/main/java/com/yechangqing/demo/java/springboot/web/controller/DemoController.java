package com.yechangqing.demo.java.springboot.web.controller;

import com.yechangqing.demo.java.springboot.web.vo.TestVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @PostMapping("/test1/{id}/{name}")
  public String test1(TestVo testVo) {
    throw new RuntimeException("error");
  }

  @GetMapping("/test2")
  public String test2() {
    return "success";
  }
}
