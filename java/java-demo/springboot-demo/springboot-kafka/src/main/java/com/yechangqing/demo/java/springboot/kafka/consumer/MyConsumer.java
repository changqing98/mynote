package com.yechangqing.demo.java.springboot.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

  @KafkaListener(topics = "kafka-test")
  public void consume1(ConsumerRecord<String, String> record) {
    System.out.println(record.value());
  }

  @KafkaListener(topics = "kafka-test")
  public void consume2(ConsumerRecord<String, String> record) {
    System.out.println(record.value());
  }
}
