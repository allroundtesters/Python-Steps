
case class User(name: String, age: Int)

val userBase = List(
  User("Mis", 12),
  User("Mis1", 40),
  User("Mis2", 30)
)
val middle = for (user <- userBase if user.age >= 30 && user.age <= 50)
  yield user.name
//yield for
middle.foreach(item => println("this is use " + item))
println(middle)

//Note that comprehensions are not restricted to lists.
//Every data-type that supports the operations
//withFilter, map, and flatMap
def foo(n: Int, v: Int) =
  for (i <- 0 until n;
       j <- i until n if i + j == v)
    yield (i, j)

foo(10, 10) foreach {
  case (i, j) =>
    println(s"($i,$j)")
  case _ => println("this is exception case")
}
