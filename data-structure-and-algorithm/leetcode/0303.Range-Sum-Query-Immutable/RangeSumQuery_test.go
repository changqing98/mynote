package leetcode

import "testing"

func TestNumArray_SumRange(t *testing.T) {
	type fields struct {
		nums []int
	}
	type args struct {
		i int
		j int
	}
	tests := []struct {
		name   string
		fields fields
		args   args
		want   int
	}{
		{"case1", fields{[]int{-2, 0, 3, -5, 2, -1}}, args{0, 2}, 1},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			this := Constructor(tt.fields.nums)
			if got := this.SumRange(tt.args.i, tt.args.j); got != tt.want {
				t.Errorf("NumArray.SumRange() = %v, want %v", got, tt.want)
			}
		})
	}
}
