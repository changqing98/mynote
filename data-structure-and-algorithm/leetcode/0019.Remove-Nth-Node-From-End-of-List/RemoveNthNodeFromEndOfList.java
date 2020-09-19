public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(final ListNode head, final int n) {
        int count = 1;
        ListNode slow = head;
        ListNode fast = head;
        while (count < n && fast != null) {
            fast = fast.next;
            count++;
        }
        if (count != n || fast == null) {
            return head;
        }
        if (fast.next == null) {
            return head.next;
        }
        fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        final ListNode removingNode = slow.next;
        slow.next = slow.next.next;
        removingNode.next = null;
        return head;
    }

    public static void main(final String[] args) {
        final ListNode node3 = new ListNode(3, null);
        final ListNode node2 = new ListNode(2, node3);
        final ListNode node1 = new ListNode(1, node2);
        final RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
        ListNode result = test.removeNthFromEnd(node3, 1);
        System.out.println(result);
        result = test.removeNthFromEnd(node1, 4);
        System.out.println(result);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode [next=" + next + ", val=" + val + "]";
        }
    }
}