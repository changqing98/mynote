package com.yechangqing.demo.java.springboot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

  @GetMapping("file")
  public String file(){
    return "success";
  }

  @PostMapping("upload")
  public String upload(@RequestParam(name = "file", required = true) MultipartFile file) {
    return file.getName();
  }
}
