import java.util.Arrays;

import org.junit.Test;

public class QuicklyPartitionTopKTest {

    @Test
    public void test(){
        QuicklyPartitionTopK test = new QuicklyPartitionTopK();
        int[] arr = new int[]{1,4,5,7,9,2,1,4};
        var result = test.listTopK(arr, 3);
        System.out.println(Arrays.toString(result));
    }
}
