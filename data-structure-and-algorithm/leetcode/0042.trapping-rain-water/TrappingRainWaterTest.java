import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrappingRainWaterTest {
    @Test
    public void test(){
        var test = new TrappingRainWater();
        assertEquals(6, test.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(9, test.trap(new int[]{4,2,0,3,2,5}));
    }
}
