package leetcode

import "testing"

func Test_minCostClimbingStairs2(t *testing.T) {
	type args struct {
		cost []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{"case1", args{[]int{10, 15, 20}}, 15},
		{"case2", args{[]int{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}}, 6},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minCostClimbingStairs3(tt.args.cost); got != tt.want {
				t.Errorf("minCostClimbingStairs3() = %v, want %v", got, tt.want)
			}
		})
	}
}
