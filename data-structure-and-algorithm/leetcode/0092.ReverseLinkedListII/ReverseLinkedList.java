public class ReverseLinkedList{
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode cur = head;
        ListNode pre = preHead;
        int i = 1;
        while(i < m){
            pre = cur;
            cur = cur.next;
            i++;
        }
        ListNode first = null;
        while(i <= n) {
            ListNode next = cur.next;
            cur.next = first;
            first = cur;
            cur = next;
            i++;
        }
        ListNode tmp = pre.next;
        pre.next = first;
        tmp.next = cur;
        return preHead.next;
    }
}