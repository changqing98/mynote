package main

import "fmt"

func twoSum(nums []int, target int) []int {
	nmap := make(map[int]int)
	for i := range nums {
		v, e := nmap[target - nums[i]]
		if e {
			return []int{v, i}
		} else {
			nmap[nums[i]] = i
		}
	}
	return []int{-1. -1}
}

func main() {
	result := twoSum([]int{1, 2, 4}, 5)
	fmt.Println(result)
}
