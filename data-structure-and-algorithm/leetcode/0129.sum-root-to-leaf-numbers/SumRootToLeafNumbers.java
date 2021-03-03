public class SumRootToLeafNumbers {
	static int result = 0;
	public int sumNumbers(TreeNodeTraversal root) {
		sumNumbers(root, 0);
		return result;
	}

	public void sumNumbers(TreeNodeTraversal root, int sum){
		if(root.left == null && root.right == null){
			result += sum * 10 + root.val;
			return;
		}
		if(root.left != null){
			sumNumbers(root.left, sum * 10 + root.val);
		}
		if(root.right != null){
			sumNumbers(root.right, sum * 10 + root.val);
		}
	}
}
