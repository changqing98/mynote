import java.util.Arrays;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0){
            return "0";
        }
        String[] numStrs = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            numStrs[i] = numbers[i] + "";
        }
        Arrays.sort(numStrs, (a, b) -> (a+b).compareTo(b+a));
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< numStrs.length; i++){
            result.append(numStrs[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        PrintMinNumber test = new PrintMinNumber();
        System.out.println(test.PrintMinNumber(new int[]{3, 32, 321}));
    }
}
