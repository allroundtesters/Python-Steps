abstract class A{
  val message: String
}

class B extends A {
  val message: String = "from b class"
}

trait C extends A {
  def loudMsg=message.toUpperCase()
}

trait T {
  def testIt(): Unit ={
    println("test mixin")
  }
}
class D extends B with C with T

val d = new D
println(d.message)
println(d.loudMsg)
println(d.testIt())