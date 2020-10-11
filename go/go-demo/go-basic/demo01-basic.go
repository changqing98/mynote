package main

import "fmt"

// PrintHello Demo01
func PrintHello() {
	fmt.Print("Hello")
}

// Variable Demo02
func Variable() {
	a := 3
	str := "Hello"
	var b, c = 4, 6
	println(a, str, b, c)
}

// Animal struct demo2
type Animal interface {
	wow()
}

// Cat struct demo
type Cat struct {
}

func (cat Cat) wow() {
}

func main() {
	PrintHello()
	Variable()

	cat := new(Cat)
	cat.wow()
}
