package jianzhioffer

import "strconv"

// result[i]
// if nums[i] < 5 nums[i-1] == 1,2 result[i-1] + result[i-2]
func translateNum(num int) int {
	numStr := strconv.Itoa(num)
	nums := []rune(numStr)
	length := len(nums)
	if length == 1 {
		return 1
	}
	result := make([]int, length)
	result[0] = 1
	if check(nums, 1) {
		result[1] = 2
	} else {
		result[1] = 1
	}
	for i := 2; i < length; i++ {
		if check(nums, i) {

			result[i] = result[i-1] + result[i-2]
		} else {
			result[i] = result[i-1]
		}
	}
	return result[length-1]
}

func check(nums []rune, i int) bool {
	return nums[i-1] == '1' || (nums[i-1] == '2' && nums[i] <= '5')
}
