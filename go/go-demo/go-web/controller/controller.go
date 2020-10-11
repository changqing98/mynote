package controller

import (
	"encoding/json"
	"fmt"
	"net/http"
	"web/service"
)

type response struct {
	Page   int
	Fruits []string
}

func testHTTP(w http.ResponseWriter, req *http.Request) {
	resObj := &response{
		Page:   1,
		Fruits: []string{"1", "2", "3"}}
	res, _ := json.Marshal(resObj)
	w.Write([]byte(res))
	form := req.ParseForm()
	fmt.Print(form)
	service.Test()
}

func init() {
	println("asdasda")
	http.HandleFunc("/test", testHTTP)
	http.ListenAndServe(":8080", nil)
}
