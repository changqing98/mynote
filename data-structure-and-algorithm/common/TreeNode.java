public class TreeNode {
	int val;
	TreeNodeTraversal left;
	TreeNodeTraversal right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNodeTraversal left, TreeNodeTraversal right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}


