public class Flatten {
    TreeNodeTraversal prev;
    public void flatten(TreeNodeTraversal root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}
