package basic

import (
	"encoding/json"
	"fmt"
)

type UserJSON struct {
	Name string
	Age  int
}

func main() {
	user := UserJSON{
		Name: "test",
		Age:  11,
	}
	result, _ := json.Marshal(&user)
	fmt.Print(string(result))

	var jsonStr = `{"name":"test2","Age":11}`
	json.Unmarshal([]byte(jsonStr), &user)
	fmt.Print(user)
}
