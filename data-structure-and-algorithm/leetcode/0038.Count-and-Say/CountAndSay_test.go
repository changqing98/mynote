package leetcode

import (
	"testing"
)

func Test_say(t *testing.T) {
	type args struct {
		str string
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{"case1", args{"111223"}, "312213"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := say(tt.args.str); got != tt.want {
				t.Errorf("say() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_countAndSay(t *testing.T) {
	type args struct {
		n int
	}
	tests := []struct {
		name string
		args args
		want string
	}{
		{"case1", args{5}, "111221"},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := countAndSay(tt.args.n); got != tt.want {
				t.Errorf("countAndSay() = %v, want %v", got, tt.want)
			}
		})
	}
}
