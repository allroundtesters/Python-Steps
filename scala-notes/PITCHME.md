# Scala Intro

- Scala is Object-Oriented(OO)
- Scala is Functional (FP)

---

## Scala Object Oriented

- Every Value is an Object
- Class(Type) and Trait(Behavior)
- Multiple inheritance
  * Extended By Subclassing
  * mixin-based composition

---

## Scala Functional 

- Every Function is A Value
- Higher-Order Functions
- Nested/Currying/Case Classes
- Pattern Matching
- Singleton Object to Group functions
- Extractor Objects
- For Comprehensions
- Right-ignoring sequence pattern
- Default and Named Parameters

---

## Scala Type System

- Generic Classes
- Variance Annotations
- Upper/Lower type bound
- Inner Classes and Abstract Class
- Compound Types
- Explicitly Typed Self Reference
- Implicit Parameters and Conversions
- Polymorphic methods

---

## Scala Basic Elements

- Expressions:Values & Variables
- Blocks
- Functions
- Methods
- Classes
- Case Classes
- Objects
- Traits
- Main Method

---

###  1. Expressions

- Literal Integer,String, or another value
- Operations
  
```scala
// expressions
println(1)
println(1 + 1)
println("Hello")
```

---

### 1.1 Values

use ```val``` to declare,and ```val``` is immutable

```scala
//values
val x = 1 + 1
println(x)
//value with type
val y: Int = 12;

```
---

### 1.2 Variable

use ```var``` to declare

```scala
//variables
var v = 1 + 1
println(v * v)

var v2: Int = 34
println(v2 + 123)

```

---

## 2. Blocks

Like anonymous function

```scala
println({
  val x=1+1
  x+1
})
```
---

## 3. Functions

- anonymous function 

```scala
(x: Int) => x + 1
```

- named function

```scala
var addOne = (x: Int) => x + 1
println(addOne(23))
```

- multiple and none parameters

```scala
val addTwo = (x: Int, y: Int) => x + y
var pi = () => 3.141516
println(pi())
println(addTwo(12, 34))
```
---

## 4. Methods

- multiple parameters

```scala
def add(x: Int, y: Int): Int = x + y
println(add(12, 23))
```

- multiple parameter lists

```scala
def mulParameterLists(x: Int, y: Int)(z: Int): Int = {
  (x + y) * z
}
println(mulParameterLists(1, 2)(23))
```

- no parameters

```scala
def noArgs: String = System.getProperty("name", "name")
println("Hello " + noArgs)

```

---

## 5.classes

- define class with constructor parameters

```scala
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
``` 

+++

- create new instance and invoke method

```scala
val greeter=new Greeter("Hello","Sir")
println(greeter.greet("Kevin"))
```

---

## 6.Case Classes 

- case class is immutable and compared by value by default

```scala
case class Point(x:Int,y:Int)
val p1=new Point(1,2)
val p2=new Point(1,2)
val p3=new Point(3,2)
```

- compared by value

```scala
//compared by value
println(p1==p2)
```

---

## 7.object

objects,single instances,singletons

```scala
object IDFactory{
  private var counter=0
  def create():Int={
    counter+=1
    counter
  }
}
```

use like a singleton class

```scala
val newId:Int=IDFactory.create()
println(newId)
val nextid:Int=IDFactory.create()
println(nextid)
```

---

## 8. trait

define behaviors and multiple traits could be combined

```scala
// default implementation for method
trait HelloMan{
  def helloFriend(name:String):Unit
  def helloWorld():Unit={
    println("Hello World!")
  }
}

//extend trait,override  methods(with or without implementation)
class YesMan(word:String) extends HelloMan{
  override def helloFriend(name: String): Unit = {
    println("Yes My Friend,I am "+name)
    println(word)
  }
}

val yesMan=new YesMan("My Pleasure")
yesMan.helloFriend("Mike")
```

---

## 9. Main Method

main is the entry point of an application

```scala
object MainEntry{
  def main(args: Array[String]): Unit = {
    println("Hello World")
  }
}

```

---

## Built-In Type

- Type Hierarchy

![img](docs/img/unified-types-diagram.svg)

+++

- Type Casting

![img](docs/img/type-casting-diagram.svg)

- Nothing and Null

---

## Object Oriented More

Following elements in Scala for Object Oriented:

- class
- case class
- object
- trait

+++ 

and also some conceptions are covered:

- Mixin
- Extractor Objects
- Generic Class
- Pattern Matching for Case Classes

---

### 1. class

- define class
- constructors
- private members

---

### 1.1 Define Class

Class is quite similar with JAVA. It could contains
values,variable,types,objects,traits.

- Naming: class name should be ***capitalized***
- create  new instance

```scala
class User
val user = new User
```
--- 

### 1.2 Constructors and Methods

- Constructors can have optional parameters 
by providing a default value. Defined in class,no need to 
create default constructor 

```scala
class Greeter(prefix:String="hello",suffix:String){

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
```

---

### 1.3 Private Members

- members are public by default
- Constructor parameters are private by default if without ```val``` or ```var```
- private members need ```private``` modifier, and getter/setter
  is different with JAVA,probably like Python style
in following example:

```_x,_y``` is private,set a value for private member,
need to call ```x_``` function.
 
+++ 
 
```scala
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
```

--- 

### 2. case class

- ```case class```is good for modeling immutable data
- compared by structure not reference

```scala
abstract class Notification
case class Email(sender: String, title: String, body: String) extends Notification
case class SMS(sender: String, msg: String) extends Notification
case class VoiceMail(sender: String, link: String) extends Notification
val email1=new Email("sender","title","body")
val email2=new Email("sender","title","body")
val sameEmail=email1==email2 //it is true

```

+++

- Pattern Match

Using case class to replace if/else, it is interesting feature compared with JAVA.

```scala
def showNotification(notification: Notification): String = {
  notification match {
    case Email(email, title, _) =>
      s"You got an email from $email with title: $title"
    case SMS(number, message) =>
      s"You got an SMS from $number! Message: $message"
    case VoiceMail(name, link) =>
      s"you received a Voice Mail from $name! Click the link to hear it: $link"
  }
}
val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceMail("Tom", "voicerecording.org/id/123")
println(showNotification(someSms)) // prints You got an SMS from 12345! Message: Are you there?
println(showNotification(someVoiceRecording))
```
---

### 3. object

- not only like a util class(JAVA conception),but also often associated 
with its ***companions***,a class with same name 
as object in ***same file***
- My Understanding in JAVA world: static methods and values for a Class

+++ 

```scala
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
```

---

### 4. trait

shared interface and fields between classes,especially useful as
generic types and with abstract methods.

```scala
trait Iterator[A]{
  def hasNext:Boolean
  def next():A
}
```

+++

extend trait:

```scala

trait Pet{
  val name:String
}

class Cat(val name:String) extends Pet
class Dog(val name:String) extends Pet

object TraitDemo{
    def main (args: Array[String] ): Unit = {
      val dog = new Dog("Harry")
      val cat = new Cat("Sally")

      val animals = ArrayBuffer.empty[Pet]
      animals.append(dog)
      animals.append(cat)
      animals.foreach(pet => println(pet.name))
    }
}
```

---

### 4. Class Composition/Mixin

- extends and with 
- class can only have one superclass but many mixin

+++

```scala
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
```

---

### 5. Extract Object

Extract Object is an object with ```unapply``` and ```apply```

- ```apply``` like a constructor
- ```unapply``` takes an object and give back to arguments

```scala
object CustomID {
  def apply(name:String) =s"$name--${Random.nextLong}"
  def unapply(customerID: String): Option[String] = {
    val name = customerID.split("--").head
    if (name.nonEmpty) Some(name) else None
  }
}

object CustomIDMain{
  def main(args: Array[String]): Unit = {
    val customer1ID = CustomID("abcdkid") //like a lazy,right now no one know name
    customer1ID match { 
      case CustomID(name)=>{  //apply parameter value to variable name
        println(customer1ID)
        println(name) //
      }
      case _=>println("Could not extract a CustomerID")
    }

    val customer2ID=CustomID("efkid")
    println(customer2ID)
    val CustomID(name) = customer2ID //pattern match and set name="efkid"
    println(CustomID.unapply(customer2ID).get) //unapply/restore the origin name
    println(name)
  }
}

```

---

### 6. Generic Class

- Quite similar with JAVA Generic.

```scala
class GenericClassDemo[G] {
  private var elements: List[G] = Nil

  def push(x: G) = {
    elements = x :: elements
  }

  def peek: G = elements.head

  def pop():G = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
  
  class Foo[+GenericClassDemo] // A covariant class
  class Bar[-GenericClassDemo] // A contravariant class
  class Baz[GenericClassDemo]  // An invariant class
}
```

+++

- Use different type

```scala
object GenericDemo extends App{
  val stack = new GenericClassDemo[Int]
  stack.push(123)
  stack.push(124)
  stack.push(125)
  stack.push(126)
  println(stack.pop())

  abstract class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  val fruitStack = new GenericClassDemo[Fruit]
  fruitStack.push(new Apple)
  fruitStack.push(new Banana)
  println(fruitStack.pop())
}
```

---

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

+++

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


