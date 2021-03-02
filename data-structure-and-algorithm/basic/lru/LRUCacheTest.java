import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test(){

    }

    @Test
    public void testCase1(){
        LRUCache demo = new LRUCache(2);
        demo.put(1, 1);
        demo.put(2, 2);
        System.out.println(demo.get(1));
        demo.put(3, 3);
        System.out.println(demo.get(2));
        demo.put(4, 4);
        System.out.println(demo.get(1));
        System.out.println(demo.get(3));
        System.out.println(demo.get(4));
    }

    @Test
    public void testCase2(){
        LRUCache demo = new LRUCache(3);
        demo.put(1, 1);
        demo.put(2, 2);
        demo.put(3, 3);
        demo.put(4, 4);
        System.out.println(demo.get(4));
        System.out.println(demo.get(3));
        System.out.println(demo.get(2));
        System.out.println(demo.get(1));
        demo.put(5, 5);
    }
}
