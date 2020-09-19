# 玩转单链表

[TOC]

## 单链表反转

### 非递归解法

```java
public static Node reverse(Node head) {
    if(head == null){
        return head;
    }
    Node current = head.next;
    head.next = null;
    while (current != null) {
        Node temp = current.next;
        current.next = head;
        head = current;
        current = temp;
    }
    return head;
}
```

### 递归解法

```java
public static Node reverseByRecursion(Node head) {
    if (head == null || head.next == null) {
        return head;
    }
    Node pre = reverseByRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return pre;
}
```
