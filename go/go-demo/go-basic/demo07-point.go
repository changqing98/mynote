package main

import "fmt"

func test(vari *int) {
	*vari = 10
}

func main() {
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
	var pp *int = &array[0]
	fmt.Print(pp)

	fmt.Println(*pp)
	test(&a)
	fmt.Print(a)
}
