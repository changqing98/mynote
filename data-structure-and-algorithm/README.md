# 数据结构与算法

## 一、排序算法

### 1.1 快速排序

1. 算法描述

    -   不稳定排序，
    -   先找定一个基准，然后以该基准对数组进行分区，使数组中大于该基准的数全在右侧，小于该基准的数全在左侧；
        然后在分别对基准左侧与右侧的子数组重复该操作。
2. 算法步骤

    1.  找基准
    2.  排左边
    3.  排右边

3. 算法实现

```go
package sorting

func quickSort(array []int) []int {
	doSort(array, 0, len(array)-1)
	return array
}

func doSort(array []int, i int, j int) {
	if i < j {
		// 找基准
		index := partition(array, i, j)
        // 排左边
		doSort(array, i, index-1)
        // 排右边
		doSort(array, index+1, j)
	}
}

// 找基准，并以该对数组进行"左小右大"分区
func partition(array []int, i int, j int) int {
    // 把数组中从i到j的子数组的第一个数array[i]作为基准数
	index := array[i]
	for i < j {
        // 从右往左找到第一个小于基准数的数组，使之与基准数交换
		for i < j && array[j] >= index {
			j--
		}
		array[i] = array[j]
        // 同理从左往右找到第一个大于基准数的数组，使之与基准数交换
		for i < j && array[i] < index {
			i++
		}
		array[j] = array[i]
	}
	array[i] = index
	return i
}
```

### 1.2 堆排序

1.  算法描述

    -   不稳定排序

2.  算法步骤

    1.  正序构建大顶堆，逆序构建小顶堆，从最后一个非叶子结点（len / 2 -1）构建堆
    2.  将堆顶元素与末尾元素交换，并重新调整堆

3.  算法实现

```go
package sorting

func heapSort(array []int) []int {
	length := len(array)
	for i := length/2 - 1; i >= 0; i-- {
		adjustHeap(array, i, length)
	}
	for i := length - 1; i > 0; i-- {
		swap(array, 0, i)
		adjustHeap(array, 0, i)
	}
	return array
}

func swap(array []int, i int, j int) {
	tmp := array[i]
	array[i] = array[j]
	array[j] = tmp
}

func adjustHeap(array []int, i int, length int) {
	tmp := array[i]
	for k := 2*i + 1; k < length; k = 2*k + 1 {
		if k < length-1 && array[k] < array[k+1] {
			k = k + 1
		}
		if array[k] > tmp {
			array[i] = array[k]
			i = k
		} else {
			break
		}
	}
	array[i] = tmp
}
```

### 1.3 归并排序

1.  算法描述
    -   稳定排序
    -   基于分治的思想，首先将数组拆分，分别进行排序，最后再合并
2.  算法步骤
    1.  将数组拆分
    2.  分别排序左半边数组与右半边数组
    3.  合并左半边数组与右半边数组
3.  算法实现

```go
package sorting

func sort(arr []int) []int{
	tmp := make([]int, len(arr))
	doMergeSort(arr, 0, len(arr) - 1, tmp)
	return arr
}

func doMergeSort(array []int, start int, end int, tmp []int) {
	if start < end {
		mid := (start + end) / 2
		doMergeSort(array, start, mid, tmp)
		doMergeSort(array, mid + 1, end, tmp)
		merge(array, start, mid, end, tmp)
	}
}

func merge(array []int, start int, mid int, end int, tmp []int){
	i := start
	j := mid + 1
	t := 0
	for i <= mid && j <= end {
		if array[i] < array[j] {
			tmp[t] = array[i]
			i++
		} else {
			tmp[t] = array[j]
			j++
		}
		t++
	}

	for i <= mid {
		tmp[t] = array[i]
		t++
		i++
	}

	for j <= end {
		tmp[t] = array[j]
		t++
		j++
	}
	t = 0
	for start <= end {
		array[start] = tmp[t]
		start++
		t++
	}
}
```





## 二、 TOP K算法
### 2.1 有限数集
所有的数可以全部读到内存中进行计算

#### 2.1.1 快排

首先快拍的思想是选定一个基准然后使小于该基准的数全在基准的左边，大于基准的数全在基准的右边。

因此我们可以分几下几部求解：

1.  选定一个基准p
2.  如果p < k，则在p右边数组中重新确立基准p
3.  反之p >= k，则在p左边数组中重新确立基准
4.  直到 p == k, p的左边就是k个最小的数

```go
package topk

func getLeastNumbers(arr []int, k int) []int {
	if k == 0 || k == len(arr) {
		return arr[0:k]
	}
	return helper(arr, 0, len(arr)-1, k)
}

func helper(arr []int, start int, end int, k int) []int {
	p := partition(arr, start, end)
	if k-1 == p {
		return arr[0:k]
	}
	if p < k {
		return helper(arr, p+1, end, k)
	} else {
		return helper(arr, start, p-1, k)
	}
}

func partition(arr []int, i int, j int) int {
	tmp := arr[i]
	for i < j {
		for i < j && arr[j] >= tmp {
			j--
		}
		arr[i] = arr[j]
		for i < j && arr[i] < tmp {
			i++
		}
		arr[j] = arr[i]
	}
	arr[i] = tmp
	return i
}
```
