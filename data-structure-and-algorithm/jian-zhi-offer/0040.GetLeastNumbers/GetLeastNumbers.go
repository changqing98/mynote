package jianzhioffer

func getLeastNumbers(arr []int, k int) []int {
	if k == 0 || k == len(arr) {
		return arr[0:k]
	}
	return helper(arr, 0, len(arr)-1, k)
}

func helper(arr []int, start int, end int, k int) []int {
	p := partition(arr, start, end)
	if k-1 == p {
		return arr[0:k]
	}
	if p < k {
		return helper(arr, p+1, end, k)
	} else {
		return helper(arr, start, p-1, k)
	}
}

func partition(arr []int, i int, j int) int {
	tmp := arr[i]
	for i < j {
		for i < j && arr[j] >= tmp {
			j--
		}
		arr[i] = arr[j]
		for i < j && arr[i] < tmp {
			i++
		}
		arr[j] = arr[i]
	}
	arr[i] = tmp
	return i
}
