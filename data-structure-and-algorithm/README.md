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

首先快排的思想是选定一个基准然后使小于该基准的数全在基准的左边，大于基准的数全在基准的右边。

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

## 三、 玩转单链表

### 3.1 单链表反转

```go
package main

import (
	"fmt"
	"strconv"
)

// ListNode 单链表定义
type ListNode struct {
	val  int
	next *ListNode
}

func (node *ListNode) String() string {
	var next string
	if node.next == nil {
		next = "nil"
	} else {
		next = node.next.String()
	}
	return "[val:" + strconv.Itoa(node.val) + ", next:" + next + "]"
}

// 1. 非递归实现
func reverse(head *ListNode) *ListNode {
	if head == nil {
		return head
	}
	var cur = head.next
	head.next = nil
	var tmp *ListNode
	for cur != nil {
		tmp = cur.next
		cur.next = head
		head = cur
		cur = tmp
	}
	return head
}

// 2. 递归实现
func reverseByRecursion(head *ListNode) *ListNode {
	if head == nil || head.next == nil {
		return head
	}
	var pre = reverse(head.next)
	head.next.next = head
	head.next = nil
	return pre
}

func main() {
	node3 := ListNode{
		val:  3,
		next: nil,
	}
	node2 := ListNode{
		val:  2,
		next: &node3,
	}
	node1 := ListNode{
		val:  1,
		next: &node2,
	}
	fmt.Println(reverse(&node1).String())
	fmt.Println(reverseByRecursion(&node3).String())
}
```

### 3.2 单链表K个结点为一组进行反转

[leetcode: 25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)

```go
package main

import (
	"fmt"
	"strconv"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func (node *ListNode) String() string {
	var next string
	if node.Next == nil {
		next = "nil"
	} else {
		next = node.Next.String()
	}
	return "[val:" + strconv.Itoa(node.Val) + ", next:" + next + "]"
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	tmp := head
	count := 0
	for tmp != nil && count < k {
		count++
		tmp = tmp.Next
	}
	if count < k {
		return head
	}
	count = 0
	cur := head
	var next *ListNode = nil
	var pre *ListNode = nil
    // 经过反转之后头结点则会变成分组的尾结点
	reverseTail := head
    // 反转第一组k个数
	for cur != nil && count < k {
		next = cur.Next
		cur.Next = pre
		pre = cur
		cur = next
		count++
	}
	if next != nil {
        // 递归反转以第K+1个结点为首的后续结点
		reverseTail.Next = reverseKGroup(next, k)
	}
	return pre
}

func main() {
	node5 := ListNode{5, nil}
	node4 := ListNode{4, &node5}
	node3 := ListNode{3, &node4}
	node2 := ListNode{2, &node3}
	node1 := ListNode{1, &node2}
	result := reverseKGroup(&node1, 2)
	fmt.Print(result.String())
}
```

### 3.3 单链表环的入口

```java
public class EntryNodeOfLoop {

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode slow = pHead;
		ListNode fast = pHead;
		boolean flag = false;
		// 首先判断是否有环
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = true;
				break;
			}
		}
		// 如果没有环直接返回null
		if (!flag) {
			return null;
		}
		// 当两个指针在环上相遇，将其中一个指针指向头节点，另一个继续呆在相遇点，然后两个指针继续向前遍历，下次相遇点就是环的入口
		fast = pHead;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	private static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
```
