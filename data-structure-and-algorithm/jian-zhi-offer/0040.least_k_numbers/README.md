# 最小的k个数

[TOC]

## 思路

典型的topk问题可基于堆排序、快排等思想

## Solution

### 堆排序

大顶堆或小定堆可以被看作一个完全二叉树，在实现的过程中，常使用数组实现（数组其实是可以构建一颗树滴哦）

大顶堆: 每个节点的数值大于等于其左右节点的数值
小顶堆: 每个节点的数值小于等于其左右节点的数值

- topk小 建大顶堆
- topk大 建小顶堆
- 堆排序 升序排序 建大顶堆
- 堆排序 降序排序 建小顶堆

### Java优先级队列 PriorityQueue

Java优先级队列 PriorityQueue，在每次增删操作时，队列里面的元素始终是有序的

```java
public int[] getLeastNumbers(int[] arr, int k) {
    Queue<Integer> queue = new PriorityQueue<>(k);
    for (int j : arr) {
        queue.offer(j);
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
        result[i] = queue.poll();
    }
    return result;
}
```
