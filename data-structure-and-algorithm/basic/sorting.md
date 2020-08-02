# 排序算法

## 插入排序

```java
void insertionSort(int[] array) {
    int n = array.length;
    for (int i = 1; i < n; i++) {
        int j;
        for (j = i; j > 0 && array[i] < array[j - 1]; j--) {
            array[j] = array[j-1];
        }
        array[j] = array[i];
    }
}
```

