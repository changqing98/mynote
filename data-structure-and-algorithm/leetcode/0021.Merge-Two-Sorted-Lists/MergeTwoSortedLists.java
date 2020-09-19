public class MergeTwoSortedLists{

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(l1 != null && l2 != null){
            var val1 = l1.val;
            var val2 = l2.val;
            if(val1 < val2){
                cur.next = new ListNode(val1);
                l1 = l1.next;
            }else {
                cur.next = new ListNode(val2);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while(l1 != null){
            cur.next = new ListNode(l1.val);
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null){
            cur.next = new ListNode(l2.val);
            l2 = l2.next;
            cur = cur.next;
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
