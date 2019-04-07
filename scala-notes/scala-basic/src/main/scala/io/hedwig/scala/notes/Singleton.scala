/**
  * 1. author: patrick
  */

// could be used as trait or class
object Blah{
  def sum(l:List[Int]):Int =l.sum
}
class IntPair(val x:Int,val y:Int)

object IntPair{
  import math.Ordering
  implicit def ipord: Ordering[IntPair] =
    Ordering.by(ip=>(ip.x,ip.y))
}

class X {
  import X._
  def blah=foo // all static in object
}

object X {
  private def foo=42
}
object ObjectObject{
  def main(args: Array[String]): Unit = {
    val x = new X
    println(x.blah)
  }
}