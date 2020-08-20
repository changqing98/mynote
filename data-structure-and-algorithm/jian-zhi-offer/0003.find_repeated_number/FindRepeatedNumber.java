public class FindRepeatedNumber {
	// 原数组置换
	public int findRepeatNumber(int[] nums) {
		int tmp;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				tmp = nums[i];
				if (nums[tmp] == tmp) {
					return tmp;
				}
				nums[i] = nums[tmp];
				nums[tmp] = tmp;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindRepeatedNumber test = new FindRepeatedNumber();
		var case1 = new int[]{1, 3, 2, 4, 0, 4};
		var result = test.findRepeatNumber(case1);
		System.out.println(result);
	}
}
