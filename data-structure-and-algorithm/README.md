# 数据结构与算法

## 排序算法

### 快速排序
1. 快排思想

先找定一个基准，然后以该基准对数组进行分区，使数组中大于该基准的数全在右侧，小于该基准的数全在左侧；
然后在分别对基准左侧与右侧的子数组重复该操作。

2. 口诀

- 找基准
- 排左边
- 排右边

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

