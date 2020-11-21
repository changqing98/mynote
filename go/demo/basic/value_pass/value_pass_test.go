package value_pass

import (
	"fmt"
	"testing"
)

func changeSlice(slice []int) {
	slice[0] = 1
}

func Test_value_pass(t *testing.T) {
	arr := []int{2}
	changeSlice(arr)
	fmt.Print(arr)
}

type ValuePass struct {
	name string
}

func struct_value_pass(pass ValuePass) {
	pass.name = "new_value"
}

func Test_struct_value_pass(t *testing.T) {
	value := ValuePass{"origin_value"}
	struct_value_pass(value)
	fmt.Println(value.name)
}

func struct_pointer_pass(pass *ValuePass) {
	pass.name = "new_value"
}

func Test_struct_pointer_pass(t *testing.T) {
	value := ValuePass{"origin_value"}
	struct_pointer_pass(&value)
	fmt.Println(value.name)
}
