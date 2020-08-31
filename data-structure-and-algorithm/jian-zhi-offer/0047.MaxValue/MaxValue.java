public class MaxValue {

	/**
	 * max[i][j] = min(max[i-1][j], max[i][j-1]) + array[i][j]
	 * i=0 j=0 max[i][j] = array[0][0]
	 * i=0 j>0 max[i][j] = max[i][j-1] + array[i][j]
	 * i>0 j=0 max[i][j] = max[i-1][j] + array[i][j]
	 * */
	public int maxValue(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		for(int i = 1; i < col; i++){
			grid[0][i] += grid[0][i-1];
		}
		for(int i = 1; i < row; i++){
			grid[i][0] += grid[i-1][0];
		}
		for(int i = 1; i < row; i++){
			for(int j = 1; j < col; j++){
				grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
			}
		}
		return grid[row-1][col-1];
	}

	// 递归
	// public int f(int i, int j, int[][] grid){
	// 	if(i==0 && j==0){
	// 		return grid[i][j];
	// 	}
	// 	if(i== 0){
	// 		return f(i, j-1, grid) + grid[i][j];
	// 	}
	// 	if(j==0){
	// 		return f(i-1, j, grid) + grid[i][j];
	// 	}
	// 	return Math.max(f(i-1, j, grid), f(i, j-1, grid)) + grid[i][j];
	// }

	public static void main(String[] args) {
		MaxValue test = new MaxValue();
		System.out.println(test.maxValue(new int[][]{{1}}));
		System.out.println(test.maxValue(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
		System.out.println(test.maxValue(new int[][]{{9, 1, 4, 8}}));
	}
}
