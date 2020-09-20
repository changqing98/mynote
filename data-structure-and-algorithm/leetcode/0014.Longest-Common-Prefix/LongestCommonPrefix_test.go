package main

import (
	"testing"
)

func TestLongestCommonPrefix(t *testing.T) {
	cases := []struct {
		input    []string
		expected string
	}{
		{
			[]string{"12", "12"}, "12",
		},
		{
			[]string{"12"}, "12",
		},
		{
			[]string{"flower", "flow", "flight"}, "fl",
		},
		{
			[]string{"dog", "racecar", "car"}, "",
		},
	}

	for _, c := range cases {
		actual := longestCommonPrefix(c.input)
		if actual != c.expected {
			t.Errorf("longeslongestCommonPrefix(%v) = %s, expected = %s", c.input, actual, c.expected)
		}
	}
}
