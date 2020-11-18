public class UniquePaths2{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[n-1] = obstacleGrid[m-1][n-1] ^ 1;
        for (int i = m-1; i>=0; i--){
            for (int j = n-1; j >=0; j--){
                if (obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }else if (j < n-1) {
                    dp[j] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }
}