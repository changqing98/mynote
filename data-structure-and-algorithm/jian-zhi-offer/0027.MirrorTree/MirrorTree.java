public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root != null){
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
        }
        return root;
    }

    public static void main(String[] args) {

    }

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
