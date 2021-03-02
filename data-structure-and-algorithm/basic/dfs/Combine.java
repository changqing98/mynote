import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

public class Combine {

    public List<int[]> combine(int[] nums, int m){
        int[] item = new int[m];
        List<int[]> result = new ArrayList<>();
        dfs(nums, nums.length, m, item, result);
        return result;
    }

    private void dfs(int[] nums, int n, int m, int[] item, List<int[]> result){
        if(m == 0){
            result.add(Arrays.copyOf(item, item.length));
            return;
        }
        for(int i = n; i >= m; i--){
            item[m - 1] = nums[i - 1];
            dfs(nums, n - 1, m-1, item, result);
        }
    }
}
