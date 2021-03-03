public class UniqueBinarySearchTrees2 {
    public List<TreeNodeTraversal> generateTrees(int n) {
        if(n == 0){
            return new ArrayList();
        }
        return generate(1, n);
    }

    public List<TreeNodeTraversal> generate(int start, int end){
        List<TreeNodeTraversal> result = new ArrayList<TreeNodeTraversal>();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++){
            List<TreeNodeTraversal> allLeftTreeNodes = generate(start, i - 1);
            List<TreeNodeTraversal> allRightTreeNodes = generate(i+1, end);
            for(TreeNodeTraversal leftNode : allLeftTreeNodes){
                for (TreeNodeTraversal rightNode : allRightTreeNodes){
                    TreeNodeTraversal root = new TreeNodeTraversal(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
