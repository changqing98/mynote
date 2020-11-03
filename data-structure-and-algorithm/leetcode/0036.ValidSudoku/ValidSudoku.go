package leetcode

func isValidSudoku(board [][]byte) bool {
	// row[i][j] 表示第i行j已存在
	var row [10][10]bool
	// col[i][j] 表示第i列j已存在
	var col [10][10]bool
	// nine[i][j] 表示第i个九宫格j已存在
	var nine [10][10]bool
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++{
			if board[i][j] == '.' {
				continue
			}
			var cur = board[i][j] - '0'
			if row[i][cur] {
				return false
			}
			row[i][cur] = true
			if col[j][cur] {
				return false
			}
			col[j][cur] = true
			seq := (i / 3) * 3 + (j/3)
			if nine[seq][cur] {
				return false
			}
			nine[seq][cur] = true
		}
	}
	return true
}
