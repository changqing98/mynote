public class Main0043{

    public static String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0) return "";
        n = n % len;
        str += str;
        return str.substring(n, n+len);
    }
    public static void main(String[] args) {
        System.out.println(Main0043.LeftRotateString("abcdefg", 2));
    }
}