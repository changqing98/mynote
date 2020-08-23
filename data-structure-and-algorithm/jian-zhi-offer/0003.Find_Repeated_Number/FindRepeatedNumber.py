from typing import List


class Main03:
    def findRepeatNumber(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            while nums[i] != i :
                tmp = nums[i]
                nums[i ] = i;


if __name__ == "__main__":
    case1 = [1, 2, 3, 4, 5, 6, 2, 3]
    print(Main03().findRepeatNumber(case1))
