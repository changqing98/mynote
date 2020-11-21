package basic

import "fmt"

func main() {
	var testBool [3][3]bool
	fmt.Print(testBool)

	var testString [3][3]string
	fmt.Print(testString)

	var testInt [3][3]int
	fmt.Print(testInt)

	var testRune [3][3]rune
	fmt.Println(testRune)

	var x = '5' - '0'
	fmt.Println(rune(x))
}
