package main

import (
	"fmt"

	_ "github.com/go-sql-driver/mysql"
	"github.com/go-xorm/xorm"
)

type test struct {
	Id   int
	Name string
}

func main() {
	test := test{
		Name: "changqing2",
	}
	engine, _ := xorm.NewEngine("mysql", "root:123456@tcp(yechangqing.com:3306)/test")
	_, err := engine.Insert(&test)
	if err != nil {
		fmt.Print(err)
	}

	engine.Get(&test2)
	fmt.Print(test2)
}
