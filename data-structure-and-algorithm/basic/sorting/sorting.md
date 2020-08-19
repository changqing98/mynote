# 排序算法

本文主要介绍了八大基本排序算法的设计思想及实现原理，努力更新中💪💪💪

[toc]

## 快速排序

```java
public static void sort(int[] array) {
    sort(array, 0, array.length - 1);
}

public static void sort(int[] array, int start, int end) {
    if (start < end) {
        int p = partition(array, start, end);
        sort(array, start, p - 1);
        sort(array, p + 1, end);
    }
}

public static int partition(int[] array, int start, int end) {
    int tem = array[start];
    while (start < end) {
        while (start < end && array[end] >= tem) {
            end--;
        }
        array[start] = array[end];
        while (start < end && array[start] < tem) {
            start++;
        }
        array[end] = array[start];
    }
    array[start] = tem;
    return start;
}
```

## 堆排序

```java
public static int[] heapSort(int[] array) {
    int len = array.length;
    // 从最后一个非叶子结点开始调整堆
    // 正序排列（由小到大）构建大顶堆，反之构建小顶堆
    for (int i = len / 2 - 1; i >= 0; i--) {
        adjustHeap(array, i, len);
    }
    // 由上面的初始操作构建一个大顶堆
    // 将堆顶的元素(最大的元素)与数据最后一个节点交换，再次调整堆得到得到剩余元素的最大元素，重复执行该操作
    for (int i = len - 1; i > 0; i--) {
        swap(array, 0, i);
        adjustHeap(array, 0, i);
    }
    return array;
}

public static void swap(int[] array, int a, int b) {
    int tem = array[a];
    array[a] = array[b];
    array[b] = tem;
}

public static void adjustHeap(int[] array, int i, int len) {
    // 保存当前节点
    int tem = array[i];
    // 指针指向左子节点
    // 二叉树的左子节点计算公式
    for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
        // 比较左子节点与右子节点，将指针指向大的那个
        if (k < len - 1 && array[k + 1] > array[k]) {
            k = k + 1;
        }
        if (array[k] > tem) {
            array[i] = array[k];
            i = k;
        } else {
            break;
        }
    }
    array[i] = tem;
}
```

## 归并排序

```java

```

## 插入排序

时间复杂度：$O(n^2)$

```java
public static void insertionSort(int[] array) {
    int n = array.length;
    for (int i = 1; i < n; i++) { 
        int j;
        for (j = i; j > 0 && array[i] < array[j - 1]; j--) {
            array[j] = array[j - 1];
        }
        array[j] = array[i];
    }
}
```

## 选择排序

```java
public static void swap(int[] array, int x, int y) {
    int tem = array[x];
    array[x] = array[y];
    array[y] = tem;
}

public static void sort(int[] array) {
    int n = array.length;
    for (int i = 0; i < array.length - 1; i++) {
        int min = i;
        for (int j = i + 1; j <= array.length - 1; j++) {
            if (array[j] < array[min]) {
                min = j;
            }
        }
        swap(array, i, min);
    }
}
```

