package string

import (
	"fmt"
	"reflect"
	"strconv"
	"testing"
)

func Test_strToInt(t *testing.T) {
	result, _ := strconv.Atoi("123")
	fmt.Print(result)
}

func Test_strToRuneArray(t *testing.T) {
	result := []rune("123")
	fmt.Println(result)
	x := '1'
	fmt.Printf("%c", x)
}

func Test_str(t *testing.T){
	str := "123"
	result := []rune(str)
	result = append(result, '4')
	fmt.Println(reflect.TypeOf(str[1]))
	fmt.Println(string(result))
}
