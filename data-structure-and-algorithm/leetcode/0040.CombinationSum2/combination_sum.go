package leetcode

import "sort"

func combinationSum2(candidates []int, target int) [][]int {
	var result [][]int
	var tmp []int
	sort.Ints(candidates)
	dfs(candidates, target, 0, &result, tmp, 0)
	return result
}

func dfs(candidates []int, target int, sum int, result *[][]int, tmp []int, k int) {
	if sum == target {
		var item []int = make([]int, len(tmp))
		copy(item, tmp)
		*result = append(*result, item)
		return
	}
	if sum > target {
		return
	}
	for i := k; i < len(candidates); i++ {
		if i != k && candidates[i] == candidates[i-1] {
			continue
		}
		sum += candidates[i]
		tmp = append(tmp, candidates[i])
		dfs(candidates, target, sum, result, tmp, i+1)
		sum -= candidates[i]
		tmp = tmp[:len(tmp)-1]
	}
}
