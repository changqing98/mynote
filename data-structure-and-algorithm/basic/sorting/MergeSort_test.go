package sorting

import (
	"reflect"
	"testing"
)

func Test_sort(t *testing.T) {
	type args struct {
		arr []int
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{"case0", args{[]int{1}}, []int{1}},
		{"case1", args{[]int{1, 2, 3, 3, 2, 1}}, []int{1, 1, 2, 2, 3, 3}},
		{"case2", args{[]int{1, 1, 1}}, []int{1, 1, 1}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := sort(tt.args.arr); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("sort() = %v, want %v", got, tt.want)
			}
		})
	}
}
