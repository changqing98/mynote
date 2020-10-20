package main

import "fmt"

func movingCount(m int, n int, k int) int {
	visited := make([][]bool, m)
	dir := [4][2]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	for i := 0; i < m; i++ {
		visited[i] = make([]bool, n)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			visited[i][j] = false
		}
	}
	var queue = make([][]int, 0)
	result := 0
	queue = append(queue, []int{0, 0})
	visited[0][0] = true
	for len(queue) > 0 {
		cur := queue[0]
		result = result + 1
		queue = queue[1:]
		i := cur[0]
		j := cur[1]
		for d := range dir {
			targetI := i + dir[d][0]
			targetJ := j + dir[d][1]
			if 0 <= targetI && targetI < m && 0 <= targetJ && targetJ < n && !visited[targetI][targetJ] && getSum(targetI)+getSum(targetJ) <= k {
				visited[targetI][targetJ] = true
				queue = append(queue, []int{targetI, targetJ})
			}
		}
	}
	return result
}

func getSum(num int) int {
	result := 0
	for num > 0 {
		result = result + num%10
		num = num / 10
	}
	return result
}

func main() {
	fmt.Print(movingCount(2, 3, 17))
}
