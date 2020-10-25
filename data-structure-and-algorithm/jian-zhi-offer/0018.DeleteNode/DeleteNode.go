package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteNode(head *ListNode, val int) *ListNode {
	if head.Val == val {
		return head.Next
	}
	var cur = head.Next
	var pre = head
	for cur != nil && cur.Val != val {
		cur = cur.Next
		pre = pre.Next
	}
	if cur != nil && cur.Val == val {
		pre.Next = cur.Next
		cur.Next = nil
	}
	return head
}

func main() {
	node3 := ListNode{
		Val: 3,
		Next: nil,
	}
	node2 := ListNode{
		Val: 2,
		Next: &node3,
	}
	node1 := ListNode{
		Val: 1,
		Next: &node2,
	}
	result := deleteNode(&node1, 2)
	for result != nil {
		fmt.Print(result.Val)
		result = result.Next
	}
}
