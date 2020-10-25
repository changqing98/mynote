package sorting

func InsertionSort(array []int) []int{
	len := len(array)
	if len <= 1 {
		return array
	}
	for i := 1; i < len; i++ {
		var tmp = array[i]
		var j int
		for j = i; j > 0 && array[j-1] > tmp; j-- {
			array[j] = array[j-1]
		}
		array[j] = tmp
	}
	return array
}
