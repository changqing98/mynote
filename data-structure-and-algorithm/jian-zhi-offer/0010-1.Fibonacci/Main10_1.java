public class Main10_1 {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        int sum = 0;
        for(int i = 0; i < n;i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
    public static void main(String[] args) {
        Main10_1 test = new Main10_1();
        System.out.println(test.fib(5));
    }
}