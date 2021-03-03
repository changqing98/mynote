public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNodeTraversal root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNodeTraversal> queue = new LinkedList<TreeNodeTraversal>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 1; i <= size; i++){
                TreeNodeTraversal rm = queue.poll();
                if(i == size){
                    result.add(rm.val);
                }
                if(rm.left != null){
                    queue.add(rm.left);
                }
                if(rm.right != null){
                    queue.add(rm.right);
                }
            }
        }
        return result;
    }
}
