import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序， 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。 （注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
	public boolean isPopOrder(int[] pushA, int[] popA) {
		if (popA.length == 0 || pushA.length == 0) {
			return false;
		}
		int i = 0;
		int j = 0;
		var s = new Stack<Integer>();
		s.push(pushA[i++]);
		while (j <= popA.length - 1) {
			while (s.peek() != popA[j]) {
				if (i == pushA.length) {
					return false;
				}
				s.add(pushA[i++]);
			}
			j++;
			s.pop();
		}
		return true;
	}

	public static void main(String[] args) {
		var test = new IsPopOrder();
		System.out.println(test.isPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }));
	}
}
