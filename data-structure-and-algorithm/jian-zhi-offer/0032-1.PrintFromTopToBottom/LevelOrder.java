import java.util.*;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class LevelOrder {

	public int[] levelOrder(TreeNode root) {
		if (root == null) {
			return new int[] {};
		}
		TreeNode node = root;
		LinkedList<TreeNode> list = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		list.add(root);
		while (!list.isEmpty()) {
			node = list.poll();
			result.add(node.val);
			if (node.left != null) {
				list.offer(node.left);
			}

			if (node.right != null) {
				list.offer(node.right);
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		LevelOrder test = new LevelOrder();
		var result = test.levelOrder(root);
		System.out.println(result);
	}
}
