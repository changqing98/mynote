package leetcode

import (
	"math"
	"sort"
)

func threeSumClosest(nums []int, target int) int {
	gap := math.MaxInt32
	result := 0
	if len(nums) <= 3{
		for _, v := range nums{
			result = result + v
		}
		return result
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
			newGap := abs(target - sum)
			if newGap < gap {
				gap = newGap
				result = sum
			}
			if sum < target {
				i++
				for i < j && nums[i] == nums[i - 1] {
					i++
				}
			} else if sum > target{
				j--
				for i < j && nums[j+1] == nums[j] {
					j--
				}
			} else {
				return target
			}
		}
	}
	return result
}

func abs(x int) int{
	if x < 0 {
		return -x
	}
	return x
}
