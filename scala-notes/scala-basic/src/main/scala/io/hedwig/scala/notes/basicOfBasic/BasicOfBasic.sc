// expressions
println(1)
println(1 + 1)
println("Hello")

//values
val x = 1 + 1
println(x)
//value with type
val y: Int = 12;

//variables
var v = 1 + 1
println(v * v)

var v2: Int = 34
println(v2 + 123)
//block

println({
  val x=1+1
  x+1
})

//Functions
//anonymous function and named
(x: Int) => x + 1
var addOne = (x: Int) => x + 1
println(addOne(23))
//multiple and none parameters
val addTwo = (x: Int, y: Int) => x + y
var pi = () => 3.141516
println(pi())
println(addTwo(12, 34))

//methods
//multiple parameters
def add(x: Int, y: Int): Int = x + y
println(add(12, 23))


//multiple parameter lists
def mulParameterLists(x: Int, y: Int)(z: Int): Int = {
  (x + y) * z
}
println(mulParameterLists(1, 2)(23))

//no parameters
def noArgs: String = System.getProperty("name", "name")
println("Hello " + noArgs)

//classes
class Greeter(prefix:String,suffix:String){
  def greet(name:String):String={
    "%s.%s.%s".format(
      prefix,name,suffix
    )
  }

  /**
    * Unit type like void in JAVA
    * @param name
    */
  def voidGreet(name:String):Unit={
    println(greet(name))
  }
}

val greeter=new Greeter("Hello","Sir")
println(greeter.greet("Kevin"))


//Case Classes is immutable and compared by value by default
case class Point(x:Int,y:Int)

val p1=new Point(1,2)
val p2=new Point(1,2)
val p3=new Point(3,2)
//compared by value
println(p1==p2)

//objects,single instances,singletons
object IDFactory{
  private var counter=0
  def create():Int={
    counter+=1
    counter
  }
}

val newId:Int=IDFactory.create()
println(newId)
val nextid:Int=IDFactory.create()
println(nextid)

//trait for fields and methods
trait HelloMan{
  def helloFriend(name:String):Unit
  def helloWorld():Unit={
    println("Hello World!")
  }
}

//extend trait
class YesMan(word:String) extends HelloMan{
  override def helloFriend(name: String): Unit = {
    println("Yes My Friend,I am "+name)
    println(word)
  }
}

val yesMan=new YesMan("My Pleasure")
yesMan.helloFriend("Mike")

//Main Method

object MainEntry{
  def main(args: Array[String]): Unit = {
    println("Hello World")
  }
}





