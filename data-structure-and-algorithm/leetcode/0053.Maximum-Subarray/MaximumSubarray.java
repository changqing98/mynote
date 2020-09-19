public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum <= 0){
                sum = nums[i];
            }else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        
    }
}
