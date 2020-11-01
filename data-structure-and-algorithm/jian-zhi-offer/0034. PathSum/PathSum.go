package jianzhioffer

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func pathSum(root *TreeNode, sum int) [][]int {
	var tmp []int
	var res [][]int
	helper(root, sum, tmp, &res)
	return res
}

func helper(root *TreeNode, sum int, tmp []int, result *[][]int) {
	if root == nil {
		return
	}
	tmp = append(tmp, root.Val)
	sum = sum - root.Val
	if sum == 0 && root.Left == nil && root.Right == nil {
		item := make([]int, len(tmp))
		copy(item, tmp)
		*result = append(*result, item)
		return
	}
	helper(root.Left, sum, tmp, result)
	helper(root.Right, sum, tmp, result)
}
