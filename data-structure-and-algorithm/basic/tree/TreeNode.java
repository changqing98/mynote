public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 递归实现先序遍历
    public static void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    // 递归实现中序遍历
    public static void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.println(root.val);
            inOrderTraverse(root.right);
        }
    }

    // 递归实现后序遍历
    public static void postOrderTraverse(TreeNode root) {
        if (root != null){
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.println(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode c = new TreeNode(3, f, null);
        TreeNode b = new TreeNode(2, d, e);
        TreeNode a = new TreeNode(1, b, c);
        System.out.println("*****递归实现先序遍历*****");
        preOrderTraverse(a);
        System.out.println("*****递归实现中序遍历*****");
        inOrderTraverse(a);
        System.out.println("*****递归实现后序遍历*****");
        postOrderTraverse(a);
    }
}