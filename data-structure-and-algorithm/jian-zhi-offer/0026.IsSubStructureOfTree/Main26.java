public class Main26 {
    
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null){
            return false;
        }
        return parse(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean parse(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null || A.val != B.val){
            return false;
        }
        return parse(A.left, B.left) && parse(A.right, B.right);
    }

    public static void main(String[] args) {
        
    }
}