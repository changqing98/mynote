package com.yechangqing.demo.java.springboot.oauth.controller;

import com.yechangqing.demo.java.springboot.oauth.filter.UserInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @PostMapping("testAuth")
  @PreAuthorize("isAuthenticated()")
  public String testAuth() {
    var userInfo =  SecurityContextHolder.getContext().getAuthentication();
    System.out.print(userInfo);
    return "success";
  }

  @PostMapping
  public String testUnAuth() {
    return "succes";
  }
}
