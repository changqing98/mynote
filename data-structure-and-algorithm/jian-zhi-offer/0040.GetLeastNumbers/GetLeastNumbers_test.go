package jianzhioffer

import (
	"reflect"
	"testing"
)

func Test_getLeastNumbers(t *testing.T) {
	type args struct {
		arr []int
		k   int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{"case0", args{[]int{1,2,3}, 0}, []int{}},
		{"case1", args{[]int{1, 2, 2, 4, 5}, 3}, []int{1, 2, 2}},
		{"case2", args{[]int{0, 0, 2, 3, 2, 1, 1, 2, 0, 4}, 10}, []int{0, 0, 2, 3, 2, 1, 1, 2, 0, 4}},
		{"case3", args{[]int{0,0,0,1}, 3}, []int{0,0,0}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := getLeastNumbers(tt.args.arr, tt.args.k); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("getLeastNumbers() = %v, want %v", got, tt.want)
			}
		})
	}
}
