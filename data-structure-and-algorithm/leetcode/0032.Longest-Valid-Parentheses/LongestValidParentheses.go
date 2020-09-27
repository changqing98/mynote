package leetcode

func longestValidParentheses(s string) int {
	res := 0
	start := 0
	stack := make([]int, 0, len(s))
	for i, v := range s {
		if v == '(' {
			stack = append(stack, i)
		} else {
			if len(stack) == 0 {
				start = i + 1
			} else {
				stack = stack[:len(stack)-1]
				if len(stack) == 0 {
					cur := i - start + 1
					if cur > res {
						res = cur
					}
				} else {
					if i-stack[len(stack)-1] > res {
						res = i - stack[len(stack)-1]
					}
				}
			}
		}
	}
	return res
}
