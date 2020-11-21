package basic

import (
	"encoding/json"
	"fmt"
	"net/http"
)

type HttpResponse struct {
	Page   int
	Fruits []string
}

func testHTTP(w http.ResponseWriter, req *http.Request) {
	resObj := &HttpResponse{
		Page:   1,
		Fruits: []string{"1", "2", "3"}}
	res, _ := json.Marshal(resObj)
	w.Write([]byte(res))
	form := req.ParseForm()
	fmt.Print(form)
}

// Test main
func main() {
	println("Hello")
	http.HandleFunc("/test", testHTTP)
	http.ListenAndServe(":8080", nil)
}
