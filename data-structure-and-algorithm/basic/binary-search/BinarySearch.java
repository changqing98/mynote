public class BinarySearch {
	static int rank(int target, int[] a) {
		int l = 0;
		int r = a.length - 1;
		while (l <= r) {
			int x = (l + r) / 2;
			if (a[x] > target) {
				l = x + 1;
			} else if (a[x] < target) {
				r = x - 1;
			} else {
				return x;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(rank(5, new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9}));
	}
}
