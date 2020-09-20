package leetcode

import "testing"

func Test_isValid(t *testing.T) {
	type args struct {
		s string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{"case1", args{"{{()}}"}, true},
		{"case2", args{"{}}"}, false},
		{"case3", args{"{{(})}"}, false},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isValid(tt.args.s); got != tt.want {
				t.Errorf("isValid(%v) = %v, want %v", tt.args.s, got, tt.want)
			}
		})
	}
}
