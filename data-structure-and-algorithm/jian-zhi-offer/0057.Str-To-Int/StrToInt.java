public class StrToInt {

    public static int strToInt(String str) {
        int factor = 1;
        int result = 0;
        var array = str.toCharArray();
        char c;
        int cur;
        int threadhold = Integer.MAX_VALUE / 10;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i >= str.length()) {
            return 0;
        }
        if (array[i] == '-') {
            factor = -1;
            i++;
        } else if (array[i] == '+') {
            i++;
        }
        for (; i < str.length(); i++) {
            c = str.charAt(i);
            if (c < '0' || c > '9') {
                return result * factor;
            }
            cur = c - '0';
            if (factor > 0 && (result == threadhold && cur >= 7 || result > threadhold)) {
                return Integer.MAX_VALUE;
            }
            if (factor < 0 && (result == threadhold && cur >= 8 || result > threadhold)) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + cur;
        }
        return result * factor;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("2147483648"));
    }
}