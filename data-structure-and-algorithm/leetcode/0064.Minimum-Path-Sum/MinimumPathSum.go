package main

import "fmt"

func minPathSum(grid [][]int) int {
	row := len(grid)
	col := len(grid[0])
	for i := 1; i < row; i++ {
		grid[i][0] = grid[i][0] + grid[i-1][0]
	}
	for i := 1; i < col; i++ {
		grid[0][i] = grid[0][i-1] + grid[0][i]
	}
	for i := 1; i < row; i++ {
		for j := 1; j < col; j++ {
			grid[i][j] = grid[i][j] + min(grid[i-1][j], grid[i][j-1])
		}
	}
	return grid[row-1][col-1]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	array := [][]int{
		{1, 3, 1},
		{1, 5, 1},
		{4, 2, 1},
	}
	result := minPathSum(array)
	fmt.Print(result)
}
