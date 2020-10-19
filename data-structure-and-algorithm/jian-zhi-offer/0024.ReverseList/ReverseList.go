package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	pre := reverseList(head.Next)
	head.Next.Next = pre
	head.Next = nil
	return pre
}

func reverseList2(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	cur := head.Next
	head.Next = nil
	for cur != nil {
		tmp := cur.Next
		cur.Next = head
		head = cur
		cur = tmp
	}
	return head
}
