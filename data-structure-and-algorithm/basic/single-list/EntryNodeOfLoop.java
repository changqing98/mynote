/**
 * 链表环的入口
 */
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
}
