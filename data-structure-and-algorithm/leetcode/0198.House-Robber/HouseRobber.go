package leetcode

func rob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	if len(nums) == 2 {
		if nums[0] > nums[1] {
			return nums[0]
		}
		return nums[1]
	}
	if nums[0] > nums[1] {
		nums[1] = nums[0]
	}
	for i := 2; i < len(nums); i++ {
		sum := nums[i] + nums[i-2]
		if sum > nums[i-1] {
			nums[i] = sum
		} else {
			nums[i] = nums[i-1]
		}
	}
	return nums[len(nums)-1]
}
