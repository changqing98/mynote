package main

import (
	"fmt"
	"math"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isValidBST(root *TreeNode) bool {
	var max = math.MaxInt64
	var min = math.MinInt64
	return helper(root, min, max)
}

func helper(root *TreeNode, min int, max int) bool {
	if root == nil {
		return true
	}
	var val = root.Val
	if val <= min {
		return false
	}
	if val >= max {
		return false
	}
	return helper(root.Left, min, val) && helper(root.Right, val, max)
}

func main() {
	_ = TreeNode{
		Val:   1,
		Left:  nil,
		Right: nil,
	}

	_ = TreeNode{
		Val:   3,
		Left:  nil,
		Right: nil,
	}
	root := TreeNode{
		Val:   2147483647,
		Left:  nil,
		Right: nil,
	}
	fmt.Print(isValidBST(&root))
}
