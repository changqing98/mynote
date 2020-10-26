package sorting

func heapSort(array []int) []int {
	length := len(array)
	for i := length/2 - 1; i >= 0; i-- {
		adjustHeap(array, i, length)
	}
	for i := length - 1; i > 0; i-- {
		swap(array, 0, i)
		adjustHeap(array, 0, i)
	}
	return array
}

func swap(array []int, i int, j int) {
	tmp := array[i]
	array[i] = array[j]
	array[j] = tmp
}

func adjustHeap(array []int, i int, length int) {
	tmp := array[i]
	for k := 2*i + 1; k < length; k = 2*k + 1 {
		if k < length-1 && array[k] < array[k+1] {
			k = k + 1
		}
		if array[k] > tmp {
			array[i] = array[k]
			i = k
		} else {
			break
		}
	}
	array[i] = tmp
}
