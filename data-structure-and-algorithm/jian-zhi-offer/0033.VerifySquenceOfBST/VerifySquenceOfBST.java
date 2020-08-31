/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0) {
			return false;
		}
		return dfs(sequence, 0, sequence.length - 1);
	}

	public boolean dfs(int[] array, int start, int end) {
		if (start >= end) {
			return true;
		}
		int i = end - 1;
		while (i >= start && array[i] > array[end]) {
			i--;
		}
		for (int k = start; k <= i; k++) {
			if (array[k] > array[end]) {
				return false;
			}
		}
		for (int j = i + 1; j < end; j++) {
			if (array[j] < array[end]) {
				return false;
			}
		}
		return dfs(array, start, i) && dfs(array, i + 1, end - 1);
	}

	public static void main(String[] args) {
		VerifySquenceOfBST test = new VerifySquenceOfBST();
		boolean result = test.VerifySquenceOfBST(new int[]{5, 4, 3, 2, 1});
		System.out.println(result);
	}
}
