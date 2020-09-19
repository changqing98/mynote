public class FindRepeatedNumber {

    /**
     * 原数组置换
     *
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
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

    // 位图标记
    public static int findRepeatNumber1(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]]++;
            if (tmp[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var case1 = new int[] { 1, 2, 3, 4, 5, 6, 5, 8, 9 };
        System.out.println(findRepeatNumber1(case1));
    }
}
