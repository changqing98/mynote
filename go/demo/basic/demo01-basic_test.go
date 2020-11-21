package basic

import "testing"

func Test_basic(t *testing.T) {
	PrintHello()
	Variable()

	cat := new(Cat)
	cat.wow()
}
