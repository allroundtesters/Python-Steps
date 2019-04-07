## Functional 

- Every Function is A Value
- Higher-Order Functions
- Nested/Currying
- Case Classes/Pattern Matching: all ready in OO
- Singleton Object to Group functions:all ready in OO
- Extractor Objects:all ready in OO
- For Comprehensions
- Right-ignoring sequence pattern
- Default and Named Parameters 

---

### 1. High-Order Functions

High-Order functions take other functions as parameter.

follow example demonstrate the function as parameter:
```scala
val salaries=Seq(2000,7000,4000)
println(salaries)

val doubleSalary=(x:Int)=>x*2
//function as parameter
var promotedSalary=salaries.map(doubleSalary)
println(promotedSalary)

//another style for passing function as parameter
promotedSalary = salaries.map(_ * 2)
promotedSalary = salaries.map(item => item * 2)

```

---

### 2. Nested Function/Method

function could be defined in function
quite similar with Python

```scala
def factorial(x:Int):Int={
  def fact(x:Int,accumulator:Int):Int={
    if(x<=1) accumulator
    else fact(x-1,x*accumulator)
  }
  fact(x,1)
}
```
---

### 3. For Comprehension

For comprehension is like ```for (enumerators) yield e```

```scala
case class User(name: String, age: Int)
val userBase = List(
  User("Mis", 12),
  User("Mis1", 40),
  User("Mis2", 30)
)

//for comprehension
val middle = for (user <- userBase if user.age >= 30 && user.age <= 50)
  yield user.name
//yield for
middle.foreach(item => println("this is use " + item))
println(middle)
```

---

### 4. Default parameter value/Named Arguments

- default parameter value

```scala
def log(msg: String, level: String = "INFO"): Unit = {
  println(s"$msg-$level")
}
```

- Named Arguments: argument with name, like python

```scala
def printName(first: String, last: String): Unit = {
  println(first + " " + last)
}

printName("John", "Smith")  // Prints "John Smith"
printName(first = "John", last = "Smith")  // Prints "John Smith"
printName(last = "Smith", first = "John")  // Prints "John Smith"
```

--- 

### 5. Polymorphic Methods

Methods in Scala can be parameterized by type as well as value

```scala
def listOfDuplicates[A](x: A, length: Int): Unit =
  if (length < 1)
    println("Noting")
  else
    x::listOfDuplicates(x, length - 1)
println(listOfDuplicates[Int](3, 4))  // List(3, 3, 3, 3)
println(listOfDuplicates("La", 8)) 
```

---

### 6. Currying

Methods may define multiple parameter lists.

```scala
 def filter(xs: List[Int], p: Int => Boolean): List[Int] =

    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
         else filter(xs.tail, p)

  def modN(n: Int)(x: Int) = (x % n) == 0

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
  println(filter(nums, modN(2)))
  println(filter(nums, modN(3)))
```







