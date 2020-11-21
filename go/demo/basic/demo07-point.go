package basic

import "fmt"

func doublePointer(){
	type listNode struct{
		Val int
		Next *listNode
	}

	node2 := listNode{2, nil}
	node1 := listNode{1, &node2}

	p1 := &node1
	p2 := &p1
	fmt.Println((*p2).Next)

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
}
