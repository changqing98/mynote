package main

import "fmt"

func removeElement(nums []int, val int) int {
	len := len(nums)
	if len == 0 {
		return 0
	}
	slow := 0
	fast := 0
	for fast < len {
		if nums[fast] != val {
			nums[slow] = nums[fast]
			slow++
		}
		fast++
	}
	return slow
}
func main() {
	case1 := []int{1, 2, 3, 3, 4, 5, 5}
	result := removeElement(case1, 3)
	fmt.Print(result)
}
