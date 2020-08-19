public class MaxSubSeqSum {
	private static int max(int[] array) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int value : array) {
			int tem = sum + value;
			if (tem > 0) {
				sum += value;
			} else {
				sum = value;
			}

			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(max(new int[]{-1, -2, -3, -4}));

		System.out.println(max(new int[]{1, 2, 3, 4, 5, -14, 16}));
	}
}
