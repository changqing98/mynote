public class TreeNodeTraversal {
    int val = 0;
    TreeNodeTraversal left = null;
    TreeNodeTraversal right = null;

    public TreeNodeTraversal(int val) {
        this.val = val;
    }

    public TreeNodeTraversal(int val, TreeNodeTraversal left, TreeNodeTraversal right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 递归实现先序遍历
    public static void preOrderTraverse(TreeNodeTraversal root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    // 递归实现中序遍历
    public static void inOrderTraverse(TreeNodeTraversal root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.println(root.val);
            inOrderTraverse(root.right);
        }
    }

    // 递归实现后序遍历
    public static void postOrderTraverse(TreeNodeTraversal root) {
        if (root != null){
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.println(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNodeTraversal d = new TreeNodeTraversal(4);
        TreeNodeTraversal e = new TreeNodeTraversal(5);
        TreeNodeTraversal f = new TreeNodeTraversal(6);
        TreeNodeTraversal c = new TreeNodeTraversal(3, f, null);
        TreeNodeTraversal b = new TreeNodeTraversal(2, d, e);
        TreeNodeTraversal a = new TreeNodeTraversal(1, b, c);
        System.out.println("*****递归实现先序遍历*****");
        preOrderTraverse(a);
        System.out.println("*****递归实现中序遍历*****");
        inOrderTraverse(a);
        System.out.println("*****递归实现后序遍历*****");
        postOrderTraverse(a);
    }
}
