import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNodeTraversal root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNodeTraversal> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

	public static void main(String[] args) {

	}
}
