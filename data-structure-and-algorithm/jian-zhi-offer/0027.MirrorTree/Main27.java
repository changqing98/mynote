public class Main27 {
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
}