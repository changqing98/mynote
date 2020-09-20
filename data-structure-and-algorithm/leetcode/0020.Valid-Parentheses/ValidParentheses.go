package leetcode

func isValid(s string) bool {
	stack := make([]rune, 0)
	for _, v := range s {
		if v == '{' || v == '[' || v == '(' {
			stack = append(stack, v)
		} else {
			if len(stack) == 0 {
				return false
			}
			s := stack[len(stack)-1]
			if (v == ')' && s == '(') || (v == '}' && s == '{') || (v == ']' && s == '[') {
				stack = stack[:len(stack)-1]
			} else {
				return false
			}
		}
	}
	return len(stack) == 0
}
