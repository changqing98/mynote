public class MaxArea {
	static int maxArea(int[] data) {
		int maxArea = 0;
		int l = 0;
		int r = data.length - 1;
		while (l < r) {
			maxArea = Math.max(maxArea, Math.min(data[l], data[r]) * (r - l));
			if (data[l] < data[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		System.out.print(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
	}
}
