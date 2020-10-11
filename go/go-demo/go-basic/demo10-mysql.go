package main

import (
	"database/sql"
	"fmt"

	_ "github.com/go-sql-driver/mysql"
)

type User struct {
	id   int
	name string
}

type result struct {
	code   int
	messge string
	data   interface{}
}

func main() {
	db, err := sql.Open("mysql", "root:123456@tcp(yechangqing:3306)/test")
	if err != nil {
		fmt.Print("Error:%v", err)
	}
	_, err = db.Exec("insert into test (name) values (?)", "changqing")
	if err != nil {
		fmt.Print("Error:%v", err)
	}

	rows, err := db.Query("select * from test")
	user := new(User)
	user_map := make(map[int]string)
	for rows.Next() {
		rows.Scan(&user.id, &user.name)
		fmt.Println(*user)
		user_map[user.id] = user.name
	}
	result := new(result)
	result.code = 200
	result.messge = "success"
	result.data = user_map
	fmt.Print(*result)
}
