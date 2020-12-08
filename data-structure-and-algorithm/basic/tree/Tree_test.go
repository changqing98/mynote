package tree

import (
	"reflect"
	"testing"
)

var node5 = &TreeNode{
	val:   5,
	left:  nil,
	right: nil,
}
var node4 = &TreeNode{
	val:   4,
	left:  nil,
	right: nil,
}
var node3 = &TreeNode{
	val:   3,
	left:  nil,
	right: nil,
}
var node2 = &TreeNode{
	val:   2,
	left:  node4,
	right: node5,
}
var node1 = &TreeNode{
	val:   1,
	left:  node2,
	right: node3,
}

func Test_preOrderTraverse(t *testing.T) {

	type args struct {
		tree *TreeNode
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{"case1", args{node1}, []int{1, 2, 4, 5, 3}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := tt.args.tree.preOrderTraverse(); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("preOrderTraverse() = %v, want %v", got, tt.want)
			}
		})
	}
}

func Test_inOrderTraverse(t *testing.T) {
	type args struct {
		tree *TreeNode
	}
	tests := []struct {
		name string
		args args
		want []int
	}{
		{"case1", args{node1}, []int{4, 2, 5, 1, 3}},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := tt.args.tree.inOrderTraverse(); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("inOrderTraverse() = %v, want %v", got, tt.want)
			}
		})
	}
}
