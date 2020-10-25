package sorting

func quickSort(array []int) []int {
	doSort(array, 0, len(array)-1)
	return array
}

func doSort(array []int, i int, j int) {
	if i < j {
		index := partition(array, i, j)
		doSort(array, i, index-1)
		doSort(array, index+1, j)
	}
}

func partition(array []int, i int, j int) int {
	index := array[i]
	for i < j {
		for i < j && array[j] >= index {
			j--
		}
		array[i] = array[j]
		for i < j && array[i] < index {
			i++
		}
		array[j] = array[i]
	}
	array[i] = index
	return i
}
