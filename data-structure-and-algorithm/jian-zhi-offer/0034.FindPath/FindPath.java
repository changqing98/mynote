import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tem = new ArrayList<>();
        if (root != null) {
            dfs(root, target, result, tem);
        }
        result.sort((a, b) -> a.size() < b.size() ? 1 : -1);
        return result;
    }

    public void dfs(TreeNode node, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tem) {
        int value = node.val;
        tem.add(value);
        if (node.left == null && node.right == null) {
            if (value == target) {
                result.add(new ArrayList<>(tem));
            }
        }
        if (node.left != null) {
            dfs(node.left, target - value, result, tem);
        }
        if (node.right != null) {
            dfs(node.right, target - value, result, tem);
        }
        tem.remove(tem.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode c = new TreeNode(3, f, null);
        TreeNode b = new TreeNode(2, d, e);
        TreeNode a = new TreeNode(1, b, c);
        FindPath test = new FindPath();
        System.out.println(test.FindPath(a, 7));
    }
}
