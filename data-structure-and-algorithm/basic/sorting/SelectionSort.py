from typing import List


def sort(a: List[int]):
	length = len(a)
	for i in range(length):
		min = i
		for j in range(i + 1, length):
			if a[j] < a[min]:
				min = j
		a[i], a[min] = a[min], a[i]
