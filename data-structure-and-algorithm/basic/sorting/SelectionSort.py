from typing import List


def sort(a: List[int]):
	length = len(a)
	for i in range(length):
		min = i
		for j in range(i + 1, length):
			if a[j] < a[min]:
				min = j
		a[i], a[min] = a[min], a[i]


if __name__ == '__main__':
	array = [1, 5, 8, 3, 2, 9]
	sort(array)
	print(array)
