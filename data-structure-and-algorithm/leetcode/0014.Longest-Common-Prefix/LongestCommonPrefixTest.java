import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestCommonPrefixTest {

    @Test
    public void test(){
        var test = new LongestCommonPrefix();
        assertEquals("f", test.longestCommonPrefix(new String[]{"fa", "fb"}));
    }
}
