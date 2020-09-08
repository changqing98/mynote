package main

import "fmt"

// ListNode 单链表定义
type ListNode struct {
	val  int
	next *ListNode
}

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
	var result = reverse(&node1)
	for result != nil {
		fmt.Print(result.val)
		result = result.next
	}

	fmt.Println()

	result = reverseByRecursion(&node3)
	for result != nil {
		fmt.Print(result.val)
		result = result.next
	}
}
