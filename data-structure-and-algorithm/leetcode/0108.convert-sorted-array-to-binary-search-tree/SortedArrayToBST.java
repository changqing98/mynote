public class SortedArrayToBST {
    public TreeNodeTraversal sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNodeTraversal dfs(int nums[], int start, int end){
        if(start <= end){
            int mid = (start + end) / 2;
            TreeNodeTraversal node = new TreeNodeTraversal(nums[mid]);
            node.left = dfs(nums, start, mid - 1);
            node.right = dfs(nums, mid + 1, end);
            return node;
        }
        return null;
    }
}
