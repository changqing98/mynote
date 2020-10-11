package main

import "fmt"

// Person type
type Person interface {
	sex() string
}

// Man type
type Man struct {
	name string
	age  int
	data interface{}
}

func (man Man) sex() string {
	return "test man"
}

func main() {
	person := new(Man)
	str := person.sex()
	fmt.Print(str)
}
