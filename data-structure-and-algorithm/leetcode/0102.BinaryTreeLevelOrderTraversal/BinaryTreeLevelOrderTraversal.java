public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNodeTraversal root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNodeTraversal> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> item = new ArrayList<>();
            int size = queue.size();
            for(int i = 1; i<=size;i++){
                TreeNodeTraversal rm = queue.poll();
                item.add(rm.val);
                if(rm.left != null){
                    queue.add(rm.left);
                }
                if(rm.right != null){
                    queue.add(rm.right);
                }
            }
            result.add(item);
        }
        return result;
    }
}
