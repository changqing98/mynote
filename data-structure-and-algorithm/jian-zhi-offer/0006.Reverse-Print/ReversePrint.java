import java.util.ArrayList;
import java.util.List;

public class ReversePrint {
	/**
	 * 递归实现
	 * @param head
	 * @return
	 */
public static int[] reversePrint(ListNode head){
		if(head == null){
			return new int[]{};
		}
		List<Integer> result = new ArrayList<>();
		helper(head, result);
		int[] array = new int[result.size()];
		for(int i=0; i<result.size();i++){
			array[i] = result.get(i);
		}
		return array;
	}

	public static void helper(ListNode head, List<Integer> result) {
		if(head == null){
			return;
		}else{
			helper(head.next, result);
		}
		result.add(head.val);
	}

		/**
	 * 两次遍历
	 * 时间复杂度O(2n)
	 * 空间复杂度O(n)
	 * @param head
	 * @return
	 */
	public static int[] reversePrint2(ListNode head){
		if(head == null){
			return new int[]{};
		}
		int len = 0;
		ListNode current = head;
		while(current != null){
			len++;
			current = current.next;
		}
		int[] result = new int[len];
		while(head != null){
			result[--len] = head.val;
			head = head.next;
		}
		return result;
	}


	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		int[] result = reversePrint(node1);
		for(var i : result){
			System.out.println(i);
		}
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
