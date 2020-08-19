package main

import "fmt"

func InsertionSort(array []int) {
	len := len(array)
	if len <= 1 {
		return
	}
	for i := 1; i < len; i++ {
		var tmp = array[i]
		var j int
		for j = i; j > 0 && array[j-1] > tmp; j-- {
			array[j] = array[j-1]
		}
		array[j] = tmp
	}
}

func main() {
	var array = []int{1, 3, 5, 2, 4}
	InsertionSort(array)
	fmt.Print(array)
}
