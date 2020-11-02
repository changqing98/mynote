package leetcode

import "sort"

func threeSum(nums []int) [][]int {
	var res [][]int
	if len(nums) < 3 {
		return [][]int{}
	}
	sort.Ints(nums)
	for k := 0; k < len(nums)-2; k++ {
		if k > 0 && nums[k] == nums[k-1] {
			continue
		}
		i := k + 1
		j := len(nums) - 1
		for i < j {
			sum := nums[k] + nums[i] + nums[j]
			if sum < 0 {
				i++
				for i < j && nums[i] == nums[i - 1] {
					i++
				}
			} else if sum > 0{
				j--
				for i < j && nums[j+1] == nums[j] {
					j--
				}
			} else {
				res = append(res, []int{nums[k], nums[i], nums[j]})
				i++
				for i < j && nums[i] == nums[i-1] {
					i++
				}
				j--
				for i < j && nums[j+1] == nums[j] {
					j--
				}
			}
		}
	}
	return res
}
