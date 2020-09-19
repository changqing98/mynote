/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {

    public int NumberOf1(int n) {
        int sum = 0;
        while(n != 0){
            sum += n&1;
            n = n>>>1;
        }
        return sum;
    }
}
