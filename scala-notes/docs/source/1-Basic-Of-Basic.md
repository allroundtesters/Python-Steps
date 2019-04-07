## Scala Basic Elements

- Expressions
  * Values
  * Variables
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

Like a anonymous

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






