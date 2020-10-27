package sorting

func sort(arr []int) []int{
	tmp := make([]int, len(arr))
	doMergeSort(arr, 0, len(arr) - 1, tmp)
	return arr
}

func doMergeSort(array []int, start int, end int, tmp []int) {
	if start < end {
		mid := (start + end) / 2
		doMergeSort(array, start, mid, tmp)
		doMergeSort(array, mid + 1, end, tmp)
		merge(array, start, mid, end, tmp)
	}
}

func merge(array []int, start int, mid int, end int, tmp []int){
	i := start
	j := mid + 1
	t := 0
	for i <= mid && j <= end {
		if array[i] < array[j] {
			tmp[t] = array[i]
			i++
		} else {
			tmp[t] = array[j]
			j++
		}
		t++
	}

	for i <= mid {
		tmp[t] = array[i]
		t++
		i++
	}

	for j <= end {
		tmp[t] = array[j]
		t++
		j++
	}
	t = 0
	for start <= end {
		array[start] = tmp[t]
		start++
		t++
	}
}
