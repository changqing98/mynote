from typing import List


class Main04:
    def findNumberIn2DArray(self, matrix: List[List[int]], target: int) -> bool:
        i, j = len(matrix) - 1, 0
        while i >= 0 and j < len(matrix[0]):
            if target > matrix[i][j]:
                j += 1
            elif target < matrix[i][j]:
                i -= 1
            else:
                return True
        return False


if __name__ == "__main__":
    case1 = [[], 0]
    case2 = [[[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]], 20]
    case3 = [[[1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30]], 5]

    print(Main04().findNumberIn2DArray(case1[0], int(case1[1])))
    print(Main04().findNumberIn2DArray(case2[0], int(case2[1])))
    print(Main04().findNumberIn2DArray(case3[0], int(case3[1])))
