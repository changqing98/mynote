package leetcode

func minCostClimbingStairs(cost []int) int {
	len := len(cost)
	dp := make([]int, len)
	dp[0], dp[1] = cost[0], cost[1]
	for i := 2; i < len; i++ {
		dp[i] = cost[i] + min(dp[i-1], dp[i-2])
	}
	return min(dp[len-1], dp[len-2])
}

func sminCostClimbingStairs2(cost []int) int {
	len := len(cost)
	a, b := cost[0], cost[1]
	for i := 2; i < len; i++ {
		tmp := cost[i] + min(a, b)
		a = b
		b = tmp
	}
	return min(a, b)
}

func minCostClimbingStairs3(cost []int) int {
	var len = len(cost)
	for i := 2; i < len; i++ {
		cost[i] += min(cost[i-1], cost[i-2])
	}
	return min(cost[len-1], cost[len-2])
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
