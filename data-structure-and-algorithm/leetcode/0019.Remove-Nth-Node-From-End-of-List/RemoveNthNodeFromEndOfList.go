package main

type ListNode struct {
	Val int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	var fast = head
	var slow = head
	for i := 1; i < n && fast != nil; i++ {
		fast = fast.Next
	}
	if fast == nil {
		return head
	}
	if fast.Next == nil {
		return head.Next
	}
	fast = fast.Next
	for fast.Next != nil {
		fast = fast.Next
		slow = slow.Next
	}
	var removingNode = slow.Next
	slow.Next = slow.Next.Next
	removingNode.Next = nil
	return head
}
