package com.yechangqing.demo.java.springboot.mongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

  private final MongoTemplate mongoTemplate;

  public MongoApplication(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  public static void main(String[] args) {
    SpringApplication.run(MongoApplication.class, args);
  }

  @Override
  public void run(String... args) {
    //    var result = mongoTemplate.find(Query.query(Criteria.where("age").is(22)), Student.class);
    //    System.out.println(result);
  }
}
