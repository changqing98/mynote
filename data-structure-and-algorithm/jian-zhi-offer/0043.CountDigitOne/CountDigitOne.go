package jianzhioffer

func countDigitOne(n int) int {
	count := 0
	for n != 0 {
		if n%10 == 1 {
			count++
		}
		n = n / 10
	}
	return count
}
