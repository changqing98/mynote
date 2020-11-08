package leetcode

func combinationSum(candidates []int, target int) [][]int {
	if len(candidates) == 1 {
		if target%candidates[0] == 0 {
			var count = target / candidates[0]
			var res = make([][]int, 1)
			res[0] = make([]int, count)
			for i := 0; i < count; i++ {
				res[0][i] = candidates[0]
			}
			return res
		} else {
			return [][]int{}
		}
	}
	var res [][]int
	var tmp []int
	helper(candidates, target, tmp, &res, 0, 0)
	return res
}

func helper(candidates []int, target int, tmp []int, result *[][]int, sum int, k int) {
	if sum == target {
		var item = make([]int, len(tmp))
		copy(item, tmp)
		*result = append(*result, item)
		return
	}
	if sum > target {
		return
	}
	for i := k; i < len(candidates); i++ {
		sum += candidates[i]
		tmp = append(tmp, candidates[i])
		helper(candidates, target, tmp, result, sum, i)
		sum -= candidates[i]
		tmp = tmp[:len(tmp)-1]
	}
}
