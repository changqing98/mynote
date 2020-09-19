public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }

	private static class TreeNode {
		int val;
		LowestCommonAncestor.TreeNode left;
		LowestCommonAncestor.TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static void main(String[] args) {

    }
}
