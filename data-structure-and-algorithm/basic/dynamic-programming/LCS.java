public class LCS {
	private static int lcs(String s1, String s2) {

		char[] x = s1.toCharArray();

		char[] y = s2.toCharArray();

		int[][] result = new int[x.length + 1][y.length + 1];

		for (int i = 1; i <= x.length; i++) {
			for (int j = 1; j <= y.length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					result[i][j] = result[i - 1][j - 1] + 1;
				} else {
					result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
				}
			}
		}
		return result[x.length][y.length];
	}

	public static void main(String[] args) {
		System.out.println(lcs("12345", "3456"));
	}
}
