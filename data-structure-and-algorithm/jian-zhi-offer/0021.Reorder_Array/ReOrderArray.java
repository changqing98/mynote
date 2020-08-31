/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

	static void reOrderArray(int[] array) {
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				int tem = array[i];
				int j = i;
				while (k < j) {
					array[j] = array[j - 1];
					j--;
				}
				array[j] = tem;
				k++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[]{1, 5, 2, 6, 7, 8, 3};
		reOrderArray(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
