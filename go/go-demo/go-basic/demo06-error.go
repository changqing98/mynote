package main

import "errors"

type error interface {
	Error() string
}

func errorTest(x int) (int, error) {
	if x < 0 {
		return 0, errors.New("Num is less than 0")
	}
	return 1, nil
}

func main() {
	errorTest(-1)
}
