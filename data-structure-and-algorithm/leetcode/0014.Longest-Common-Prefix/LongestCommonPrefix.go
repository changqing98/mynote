package main

import "fmt"

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	if len(strs) == 1 {
		return strs[0]
	}
	first := strs[0]
	for maxLen := 0; maxLen < len(first); maxLen++ {
		for index := 1; index < len(strs); index++ {
			if maxLen >= len(strs[index]) || strs[index][maxLen] != first[maxLen] {
				return first[0:maxLen]
			}
		}
	}
	return first
}

func main() {
	fmt.Print(longestCommonPrefix([]string{"flower", "flow", "flight"}))
}
