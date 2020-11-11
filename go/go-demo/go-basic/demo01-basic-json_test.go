package basic

import (
	"encoding/json"
	"fmt"
	"testing"
)

func Test_json(t *testing.T) {
	user := UserJSON{
		Name: "test",
		Age:  11,
	}
	result, _ := json.Marshal(&user)
	fmt.Print(string(result))

	var jsonStr = `{"name":"test2","Age":11}`
	_ = json.Unmarshal([]byte(jsonStr), &user)
	fmt.Print(user)
}
