package main

import (
	"fmt"

	"github.com/aiscrm/redisgo"
)

type user struct {
	Id   int
	Name string
}

func main() {
	redis, _ := redisgo.New(redisgo.Options{
		Addr:     "redis:6379",
		Db:       2,
		Password: "123456",
	})
	redis.Set("test", "test", -1)
	redis.Get("test")

	fmt.Println(redis.GetString("test"))

	user1 := user{
		Id:   1,
		Name: "changqing",
	}

	redis.Set("user", user1, 1000)
	user2 := user{}
	redis.GetObject("user", user2)
	fmt.Println("user2", user2)
}
