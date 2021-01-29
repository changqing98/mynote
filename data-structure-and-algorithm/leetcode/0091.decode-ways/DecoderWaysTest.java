import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecoderWaysTest {
    @Test
    public void test() {
        DecoderWays test = new DecoderWays();
        var result = test.numDecodings("226");
        assertEquals(3, result);
    }

}
