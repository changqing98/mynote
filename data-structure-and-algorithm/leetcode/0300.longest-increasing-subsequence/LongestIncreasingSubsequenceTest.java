import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void lengthOfLIS() {
        var demo = new LongestIncreasingSubsequence();
        var actual = demo.lengthOfLIS(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 });
        assertEquals(6, actual);
        actual = demo.lengthOfLIS(new int[] { 7, 7, 7, 7, 7 });
        assertEquals(1, actual);
    }
}
