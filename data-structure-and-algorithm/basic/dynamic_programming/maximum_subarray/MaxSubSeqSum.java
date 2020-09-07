public class MaxSubSeqSum {

	private static int max(int[] array) {
		int max = array[0];
		int sum = array[0];
		for (int i = 1; i < array.length; i++) {
			if (sum > 0) {
				sum += array[i];
			} else {
				sum = array[i];
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(max(new int[]{-1, -2, -3, -4}) == -1);
		System.out.println(max(new int[]{1, 2, 3, 4, 5, -14, 16}) == 17);
	}
}
