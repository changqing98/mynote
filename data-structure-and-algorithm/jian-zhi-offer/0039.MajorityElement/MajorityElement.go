package jianzhioffer

func majorityElement(nums []int) int {
	result := 0
	votes := 0
	for _, num := range nums {
		if votes == 0 {
			result = num
		}
		if result == num {
			votes++
		} else {
			votes--
		}
	}
	return result
}
