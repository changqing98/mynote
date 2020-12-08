package tree

// TreeNode 树节点
type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

func (tree *TreeNode) preOrderTraverse() []int {
	res := []int{}
	if tree == nil {
		return res
	}
	stack := []*TreeNode{}
	for tree != nil || len(stack) != 0 {
		if tree != nil {
			res = append(res, tree.val)
			stack = append(stack, tree)
			tree = tree.left
		} else {
			tree = stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			tree = tree.right
		}
	}
	return res
}

func (tree *TreeNode) inOrderTraverse() []int {
	res := []int{}
	if tree == nil {
		return res
	}
	stack := []*TreeNode{}
	for tree != nil || len(stack) != 0 {
		if tree != nil {
			stack = append(stack, tree)
			tree = tree.left
		} else {
			tree = stack[len(stack)-1]
			res = append(res, tree.val)
			stack = stack[:len(stack)-1]
			tree = tree.right
		}
	}
	return res
}
