# 面试题03. 数组中重复的数字

## Problem

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字

**示例 1：**

```text
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
```

**限制：**

`2 <= n <= 100000`

## Solution

### 原数组置换

**该方法不需要申请额外的空间，直接在原数组的次序，但会打乱原数组次序。**

* 时间复杂度O\(n\)
* 空间复杂的O\(1\)

```java
public static int findRepeatNumber(int[] nums) {
    int tmp;
    for (int i = 0; i < nums.length; i++) {
        while (nums[i] != i) {
            tmp = nums[i];
            if (nums[tmp] == tmp) {
                return tmp;
            }
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
    }
    return -1;
}
```

### 位图标记

位图法遍历一遍数组nums，申请大小为n的一个整数数组tmp记录已经存在的值，当tmp\[nums\[i\]\] == 0是设置tmp\[nums\[i\]\] = 1，当tmp\[nums\[i\]\] == 1时，返回nums\[i\]。

* 时间复杂度O\(n\)
* 空间复杂的O\(n\)

```java
public static int findRepeatNumber1(int[] nums) {
    int[] tmp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        tmp[nums[i]]++;
        if (tmp[nums[i]] > 1) {
            return nums[i];
        }
    }
    return -1;
}
```

