  public class SingleListReverser {

	public static Node reverse(Node head) {
		if(head == null){
			return head;
		}
		Node current = head.next;
		head.next = null;
		while (current != null) {
			Node temp = current.next;
			current.next = head;
			head = current;
			current = temp;
		}
		return head;
	}

	public static Node reverseByRecursion(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node pre = reverseByRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return pre;
	}

	public static void main(String[] args) {
		Node node3 = new Node(3, null);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		Node node = new Node(0, node1);
		System.out.println(reverse(node));
		System.out.println(reverseByRecursion(node));
	}

	private static class Node {
		int value;
		Node next;

		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("{");
			sb.append("\"value\":").append(value);
			sb.append(",\"next\":").append(next);
			sb.append('}');
			return sb.toString();
		}
	}
}
