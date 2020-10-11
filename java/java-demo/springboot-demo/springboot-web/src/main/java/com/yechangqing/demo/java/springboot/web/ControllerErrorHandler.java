package com.yechangqing.demo.java.springboot.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@ControllerAdvice
public class ControllerErrorHandler {

  @ExceptionHandler(Exception.class)
  public String handle(Exception e, HttpServletResponse response) {
    response.setStatus(HttpStatus.BAD_REQUEST.value());
    return "error";
  }
}
