public class ReverseList {
	public static ListNode reverseList(ListNode headNode) {
		if (headNode == null || headNode.next == null) {
			return headNode;
		}
		ListNode pre = reverseList(headNode.next);
		headNode.next.next = headNode;
		headNode.next = null;
		return pre;
	}

	public static ListNode reverseListByNonRecurse(ListNode headNode) {
		if (headNode == null) {
			return headNode;
		}
		ListNode cur = headNode.next;
		headNode.next = null;
		ListNode tmp;
		while (cur != null) {
			tmp = cur.next;
			cur.next = headNode;
			headNode = cur;
			cur = tmp;
		}
		return headNode;
	}

	public static void main(String[] args) {

		ListNode node1 = new ListNode(1);
		System.out.println(reverseListByNonRecurse(node1));
		System.out.println(reverseList(node1));

		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		System.out.println(reverseList(node1));
		System.out.println(reverseListByNonRecurse(node1));
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
		}
	}
}
