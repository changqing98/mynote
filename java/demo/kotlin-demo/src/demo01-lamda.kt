class Test{
   fun hello(){
        print("Hello World")
    }
}

var t = Test()

fun f(test: Test.()->Unit) = t.test()

fun main() {
    f {
        hello()
    }
}
