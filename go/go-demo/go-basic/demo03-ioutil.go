package main

import (
	"log"
	"os"
)

func main() {
	file, err := os.Open("./goio_demo")
	if err != nil {
		log.Fatal(err)
	}
	buff := make([]byte, 100)
	in, err := file.Read(buff)
	if err != nil {
		log.Fatal(err)
	}
	log.Println(string(buff[0:in]))

	stat, _ := os.Stat("./goio_demo")
	log.Println(stat.Name(), stat.IsDir())
}
