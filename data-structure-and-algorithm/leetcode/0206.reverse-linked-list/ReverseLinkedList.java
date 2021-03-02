public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }
        return head;
    }
}
