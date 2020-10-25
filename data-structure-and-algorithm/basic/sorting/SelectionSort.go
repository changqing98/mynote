package sorting

import "fmt"

func SelectionSort(array []int) {
	length := len(array)
	for i := 0; i < length; i++ {
		min := i
		for j := i + 1; j < length; j++ {
			if array[j] < array[min] {
				min = j
			}
		}
		array[i], array[min] = array[min], array[i]
	}
}

func main() {
	array := []int{1, 2, 5, 6, 3, 2, 3, 4}
	SelectionSort(array)
	fmt.Println(array)
}
