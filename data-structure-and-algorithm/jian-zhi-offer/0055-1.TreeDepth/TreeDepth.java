public class TreeDepth {

	public static int TreeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
	}

	public static void main(String[] args) {
		TreeNode[] node = new TreeNode[8];
		for (int i = 1; i <= 7; i++) {
			node[i] = new TreeNode(i);
		}
		node[1].left = node[2];
		node[1].right = node[3];
		node[2].left = node[4];
		node[2].right = node[5];
		node[3].left = node[6];
		node[4].right = node[7];
		System.out.println(TreeDepth(node[1]));
	}

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
