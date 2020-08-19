public class GcdAndLcm {
	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) {
		System.out.println(gcd(20, 30));
		System.out.print(lcm(20, 30));
	}
}
