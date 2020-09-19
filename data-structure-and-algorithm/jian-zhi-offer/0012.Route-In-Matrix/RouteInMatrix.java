public class RouteInMatrix {

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean[] visited = new boolean[rows * cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(matrix, rows, cols, i, j, visited, 0, str)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[] matrix, int rows, int cols, int row, int col, boolean[] visited,
					   int k, char[] str) {
		boolean result = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && matrix[row * cols + col] == str[k]) {
			visited[row * cols + col] = true;
			k++;
			if (k == str.length) {
				return true;
			}
			if(k==10){
				System.out.println("hello");
			}
			result = dfs(matrix, rows, cols, row + 1, col, visited, k, str) ||
				dfs(matrix, rows, cols, row - 1, col, visited, k, str) ||
				dfs(matrix, rows, cols, row, col + 1, visited, k, str) ||
				dfs(matrix, rows, cols, row, col - 1, visited, k, str);
			if(!result){
				k--;
				visited[row * cols + col] = false;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RouteInMatrix test = new RouteInMatrix();
//		System.out.println(test.hasPath("ABCESFCSADEE".toCharArray(), 3, 4, "ABCCED".toCharArray()));
		System.out.println(test.hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(),
			5, 8, "SGGFIECVAASABCEHJIGQEM".toCharArray()));
	}
}
