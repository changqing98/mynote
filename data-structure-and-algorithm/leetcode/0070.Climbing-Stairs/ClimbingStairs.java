public class ClimbingStairs{

    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        int tmp;
        for (int i = 1; i<n; i++){
            tmp = a;
            a = b;
            b = a + tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        ClimbingStairs test = new ClimbingStairs();
        System.out.println(test.climbStairs(2));
        System.out.println(test.climbStairs(3));
    }
}