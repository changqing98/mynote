public class EditDistance {
	// array[i][j] 表示 word[1...i] 与 字符串word2[1...j]的距离
	// word1[i] == word2[j] min(result[i-1][j-1], result[i-1][j] + 1, result[i][j-1] + 1)
	// word1[i] != word2[j] min(result[i-1][j-1] + 1, result[i-1][j] + 1, result[i][j-1] + 1)
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] result = new int[m + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			result[0][i] = i;
		}
		for (int j = 0; j <= m; j++) {
			result[j][0] = j;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int left = result[i][j - 1] + 1;
				int up = result[i - 1][j] + 1;
				int left_up = result[i - 1][j - 1];
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					left_up += 1;
				}
				result[i][j] = Math.min(left_up, Math.min(left, up));
			}
		}
		return result[m][n];
	}
}
