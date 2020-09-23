package leetcode

import (
	"bytes"
	"strconv"
)

func countAndSay(n int) string {
	a := "1"
	for i := 1; i < n; i++ {
		a = say(a)
	}
	return a
}

func say(str string) string {
	sum := 0
	cur := rune(str[0])
	var result bytes.Buffer
	for _, c := range str {
		if c == rune(cur) {
			sum++
		} else {
			result.WriteString(strconv.Itoa(sum))
			result.WriteRune(cur)
			sum = 1
			cur = c
		}
	}
	result.WriteString(strconv.Itoa(sum))
	result.WriteRune(cur)
	return result.String()
}
