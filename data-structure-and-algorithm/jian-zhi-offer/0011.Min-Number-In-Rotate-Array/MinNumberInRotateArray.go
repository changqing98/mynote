package main

func minArray(numbers []int) int {
	l := 0
	r := len(numbers) - 1
	for l < r {
		m := (l + r) / 2
		if numbers[m] < numbers[r] {
			r = m
		} else if numbers[m] > numbers[r] {
			l = m + 1
		} else {
			r = r - 1
		}
	}
	return numbers[l]
}
