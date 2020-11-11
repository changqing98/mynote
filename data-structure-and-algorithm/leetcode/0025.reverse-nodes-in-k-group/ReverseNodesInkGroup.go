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
	reverseTail := head
	for cur != nil && count < k {
		next = cur.Next
		cur.Next = pre
		pre = cur
		cur = next
		count++
	}
	if next != nil {
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
