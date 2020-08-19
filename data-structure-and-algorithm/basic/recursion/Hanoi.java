public class Hanoi {
    public static void move(int n, char s, char h, char e) {
        if (n == 1) {
            System.out.println("move " + s + " to " + e);
        } else {
            move(n - 1, s, e, h);
            System.out.println("move " + s + " to " + e);
            move(n - 1, h, s, e);
        }
    }

    public static void main(String[] args) {
        move(3, 'A', 'B', 'C');
    }
}