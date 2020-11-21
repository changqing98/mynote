package com.yechangqing.demo.java.basic.java.util;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListDemo {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.offer(2);
    while(!queue.isEmpty()){
      System.out.println(queue.peek());
      System.out.println(queue.poll());
    }
  }
}
