import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<Integer> tmp = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		dfs(result, tmp, root, sum);
		return result;
	}

	public void dfs(List<List<Integer>> result, List<Integer> tmp, TreeNode root, int sum) {
		if (root == null) {
			return;
		}
		tmp.add(root.val);
		sum -= root.val;
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				List<Integer> item = new ArrayList<>(tmp);
				result.add(item);
			}
			return;
		}
		if (root.left != null) {
			dfs(result, tmp, root.left, sum);
			tmp.remove(tmp.size() - 1);
		}
		if (root.right != null) {
			dfs(result, tmp, root.right, sum);
			tmp.remove(tmp.size() - 1);
		}
	}
}
