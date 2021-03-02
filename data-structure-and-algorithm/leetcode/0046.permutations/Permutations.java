import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result);
        return result;
    }

    private void dfs(int[] nums, int k, List<List<Integer>> result){
        if(k == nums.length - 1){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = k; i < nums.length; i++){
            swap(nums, i, k);
            dfs(nums, k + 1, result);
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
