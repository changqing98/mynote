package com.yechangqing.demo.java.springboot.basic.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {
  @EventListener
  public void handle(EventSource eventSource) {
    System.out.println(eventSource);
    System.out.println("received");
  }
}
