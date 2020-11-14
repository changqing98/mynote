package leetcode

func convert(s string, numRows int) string {
	length := len(s)
	if length <= numRows || numRows == 1 {
		return s
	}
	result := make([]byte, 0)
	groupLength := 2*numRows - 2
	groups := length / groupLength
	if length%groupLength != 0 {
		groups++
	}
	for i := 0; i < numRows; i++ {
		for j := 0; j < groups; j++ {
			target := j*groupLength + i
			if target < length {
				result = append(result, s[target])
			} else {
				break
			}
			if i > 0 && i < numRows-1 {
				target = j*groupLength + (groupLength - i)
				if target < length {
					result = append(result, s[target])
				} else {
					break
				}
			}
		}
	}
	return string(result)
}
