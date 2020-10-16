from typing import List


class RouteInMatrix:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])
        visited = [[False] * cols] * rows
        for i in range(rows):
            for j in range(cols):
                if self.dfs(board, word, 0, 0, 0, visited) :
                    return True
        return False

    def dfs(self, board: List[List[str]], word: str, k: int, row: int, col: int, visited: List[List[bool]]) -> bool:
        result = False
        if row >= 0 and row < len(board) and col >= 0 and col < len(board[0]) and (not visited[row][col]) and k < len(word) and board[row][col] == word[k]   :
            visited[row][col] = True
            k = k + 1
            if k == len(word):
                return True
            down = self.dfs(board, word, k, row + 1, col, visited)
            up = self.dfs(board, word, k, row - 1, col, visited)
            left = self.dfs(board, word, k, row, col - 1, visited)
            right = self.dfs(board, word, k, row, col + 1, visited)
            result = down or up or left or right
            if not result :
                visited[row][col] = False
                k = k - 1
        return result

if __name__ == "__main__":
    test = RouteInMatrix()
    board = [["A","B","C","E"]]
    word = "A"
    print(test.exist(board, word))