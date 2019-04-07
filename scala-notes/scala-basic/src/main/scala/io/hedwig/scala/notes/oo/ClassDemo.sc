class Greeter(prefix: String, suffix: String) {

  def greet(name: String): String = {
    "%s.%s.%s".format(
      prefix, name, suffix
    )
  }

  /**
    * Unit type like void in JAVA
    *
    * @param name
    */
  def voidGreet(name: String): Unit = {
    println(greet(name))
  }
}

val greeter = new Greeter("Hello", "Sir")
println(greeter.greet("Kevin"))

class Point {
  private var _x = 0
  private var _y = 0
  private val bound = 1000

  def x = _x

  def x_=(newValue: Int): Unit = {
    println("set x")
    if (newValue > bound) {
      _x = newValue
    } else {
      println("Warning")
    }
  }

  def y = _y

  def y_=(newValue: Int): Unit = {
    print("set y")
    if (newValue < bound) _y = newValue else println("warning")
  }

}

val p = new Point
p.x = 10000
p.x = 100
p.y = 100
p.y = 10000