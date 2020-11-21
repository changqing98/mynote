package basic

import (
	"fmt"
	"testing"
)

func Test_doublePointer(t *testing.T) {
	doublePointer()
}

func Test_pointer(t *testing.T){
	var a int = 10
	fmt.Println(a)
	fmt.Println(&a)

	var p *int
	p = &a
	fmt.Println(p)
	fmt.Println(*p)

	var x **int
	x = &p
	a = 20
	fmt.Println(x)
	fmt.Println(*x)
	fmt.Println(**x)

	a = 20
	b := a
	c := b
	a = 30

	fmt.Println(a, b, c)

	array := []int{1, 2, 3, 4}
	fmt.Println(array)
	var pp = &array[0]
	fmt.Print(pp)

	fmt.Println(*pp)
}
