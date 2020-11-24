public class MergeKSortedLists{
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeLists(ListNode[] lists, int i, int j){
        if (i == j){
            return lists[i];
        }
        if(j - i == 1){
            ListNode li = lists[i];
            ListNode lj = lists[j];
            return merge(li, lj);
        }
        int mid = (i + j) / 2;
        ListNode li = mergeLists(lists, i, mid);
        ListNode lj = mergeLists(lists, mid + 1, j);
        return merge(li, lj);
    }

    public ListNode merge(ListNode li, ListNode lj){
        ListNode head = new ListNode();
        ListNode pHead = head;
        while (li != null && lj != null){
            if(li.val < lj.val){
                head.next = li;
                li = li.next;
            } else {
                head.next = lj;
                lj = lj.next;
            }
            head = head.next;
        }
        while(li != null){
            head.next = li;
            li = li.next;
            head = head.next;
        }

        while(lj != null){
            head.next = lj;
            lj = lj.next;
            head = head.next;
        }
        return pHead.next;
    }
}