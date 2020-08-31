public class RebuildTree {
	public TreeNode reBuildTree(int[] preorder, int[] inorder) {
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode helper(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
		if (startPre > endPre || startIn > endIn) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[startPre]);
		for (int i = startIn; i <= endIn; i++) {
			if (inorder[i] == preorder[startPre]) {
				int len = i - startIn;
				root.left = helper(preorder, startPre + 1, startPre + len, inorder, startIn, i - 1);
				root.left = helper(preorder, startPre + len + 1, endPre, inorder, i + 1, endIn);
				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
