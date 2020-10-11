import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.*;
class CoroutinesDemo{

  suspend fun test(){
    println("Hello")
    println(Thread.currentThread().name)
    Thread.sleep(10000)
    println("world")
  }
}


suspend fun main() {
  var demo = CoroutinesDemo()
  println(Thread.currentThread().name)
  GlobalScope.launch {
    demo.test();
  }
  Thread.sleep(1000)
  println("hello world")

  Thread.sleep(20000)
  println("Exit")
}
