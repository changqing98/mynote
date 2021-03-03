public class LowestCommonAncestor {
	public TreeNodeTraversal lowestCommonAncestor(TreeNodeTraversal root, TreeNodeTraversal p, TreeNodeTraversal q) {
		while (root != null) {
			if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}

	public TreeNodeTraversal lowestCommonAncestor2(TreeNodeTraversal root, TreeNodeTraversal p, TreeNodeTraversal q) {
		if (p.val > q.val) {
			TreeNodeTraversal tmp = p;
			p = q;
			q = tmp;
		}
		while (root != null) {
			if (root.val > q.val) {
				root = root.left;
			} else if (root.val < p.val) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}
}
