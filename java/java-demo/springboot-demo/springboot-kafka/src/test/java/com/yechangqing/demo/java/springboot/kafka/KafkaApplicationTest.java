package com.yechangqing.demo.java.springboot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class)
public class KafkaApplicationTest {

  private static final String TOPIC = "test-topic";

  @Autowired private KafkaTemplate<String, String> kafkaTemplate;

  @KafkaListener(topics = TOPIC, groupId = "kafka-demo")
  public void consumer(ConsumerRecord<String, String> record) {
    System.out.println(record);
  }

  @Test
  public void test() {
    kafkaTemplate.send("kafka-test", "test");
  }
}
