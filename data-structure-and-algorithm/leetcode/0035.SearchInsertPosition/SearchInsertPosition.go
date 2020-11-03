package leetcode

func searchInsert(nums []int, target int) int {
	var l = 0
	var r = len(nums) - 1
	for l < r {
		var mid = (l + r) / 2
		if nums[mid] == target {
			return mid
		} else if nums[mid] > target {
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	if target > nums[l] {
		return l + 1
	} else {
		return l
	}
}
