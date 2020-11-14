# [6. ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)

## Problem

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string s, int numRows);
```

 

**Example 1:**

```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
```

**Example 2:**

```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
```

**Example 3:**

```
Input: s = "A", numRows = 1
Output: "A"
```

 

**Constraints:**

-   `1 <= s.length <= 1000`
-   `s` consists of English letters (lower-case and upper-case), `','` and `'.'`.
-   `1 <= numRows <= 1000`



## 问题解析

如题目描述example2示例：

设字符串长度与len，行数为n

我们可以把字符串按  2 * n - 2为一组，即groupLength =  2 * n - 2

得到组数 groups =ceil（ len / groupLength）

设行数为 i，组号为g

 i = 0 与i=n-1 每组仅需展示一个字符，第 g 组展示的字符为 g * groupLength + i

i <= i <=n-2 每组需要展示两个字符，分别为  g * groupLength + i 和  g * groupLength + （groupLength - i）



```go
package leetcode

func convert(s string, numRows int) string {
	length := len(s)
	if length <= numRows || numRows == 1 {
		return s
	}
	result := make([]byte, 0)
	groupLength := 2*numRows - 2
	groups := length / groupLength
	if length%groupLength != 0 {
		groups++
	}
	for i := 0; i < numRows; i++ {
		for j := 0; j < groups; j++ {
			target := j*groupLength + i
			if target < length {
				result = append(result, s[target])
			} else {
				break
			}
			if i > 0 && i < numRows-1 {
				target = j*groupLength + (groupLength - i)
				if target < length {
					result = append(result, s[target])
				} else {
					break
				}
			}
		}
	}
	return string(result)
}
```

