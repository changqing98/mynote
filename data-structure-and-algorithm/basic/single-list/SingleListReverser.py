class ListNode:
    def __init__(self, val: int, next):
        self.val = val
        self.next = next

    def __str__(self):
        return f"[val:{self.val}, next:{str(self.next)}]"

def reverse(head: ListNode) -> ListNode:
    if head is None:
        return head
    cur: ListNode = head.next
    head.next = None
    tmp: ListNode = None
    while cur is not None:
        tmp = cur.next
        cur.next = head
        head = cur
        cur = tmp
    return head

def reverse_by_recursion(head: ListNode) -> ListNode:
    if head is None or head.next is None:
        return head
    pre: ListNode = reverse_by_recursion(head.next)
    head.next.next = head
    head.next = None
    return pre

if __name__ == "__main__":
    node3 = ListNode(3, None)
    node2 = ListNode(2, node3)
    node1 = ListNode(1, node2)
    print(reverse(node1))
    print(reverse_by_recursion(node3))

