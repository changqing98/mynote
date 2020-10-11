package main

import (
	"fmt"
	"time"
)

func f() {
	for i := 0; i < 10; i++ {
		fmt.Println("f1", i)
		time.Sleep(2 * time.Second)
	}
}

func f2() {
	for i := 0; i < 10; i++ {
		fmt.Println("f2", i)
		time.Sleep(2 * time.Second)
	}
}

func main() {
	go f()
	go f2()
	time.Sleep(10 * time.Second)
}
