package leetcode

type ListNode struct {
	Val  int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	var p = head.Next
	head.Next = swapPairs(head.Next.Next)
	p.Next = head
	return p
}
