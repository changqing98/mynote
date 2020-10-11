package main

import "github.com/kataras/iris/v12"

func main() {
	app := iris.New()
	app.Get("/", index)
	app.Get("/test", test)
	app.Listen(":8080")
}

type response struct {
	Code int
	Msg  string
}

func test(ctx iris.Context) {
	res := response{
		Code: 200,
		Msg:  "success",
	}
	ctx.JSON(res)
}

func index(ctx iris.Context) {
	ctx.HTML("<h1>Hello World</h1>")
}
