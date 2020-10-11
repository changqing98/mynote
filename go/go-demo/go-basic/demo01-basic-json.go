package main

import (
	"encoding/json"
	"fmt"
)

type User struct {
	Name string
	Age  int
}

func main() {
	user := User{
		Name: "test",
		Age:  11,
	}
	result, _ := json.Marshal(&user)
	fmt.Print(string(result))

	var jsonStr = `{"name":"test2","Age":11}`
	json.Unmarshal([]byte(jsonStr), &user)
	fmt.Print(user)
}
