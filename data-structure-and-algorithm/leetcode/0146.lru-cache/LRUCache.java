import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    int size;
    Node tail;
    Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            node = new Node(key, value);
            addToHead(node);
            size++;
            if(size > capacity){
                map.remove(tail.key);
                removeTail();
            }
            map.put(key, node);
        } else {
            moveToHead(node);
            node.value = value;
        }
    }

    private void moveToHead(Node node){
        if(node == head){
            return;
        }
        if(node == tail){
            tail = node.pre;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        node.next = head;
        head.pre = node;
        node.pre = null;
        head = node;
    }

    private void removeTail(){
        if(head == tail){
            head = null;
            tail = null;
        } else {
            Node newTail = tail.pre;
            newTail.next = null;
            tail = newTail;
        }
        size--;
    }

    private void addToHead(Node node){
        if(head == null){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    private static class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
