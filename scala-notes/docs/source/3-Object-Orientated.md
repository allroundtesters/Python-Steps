## Object Oriented More

Following elements in Scala for Object Oriented:

- class
- case class
- object
- trait

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

case class is good for modeling immutable data

- ```case class```
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

object is 
- like a util class(private constructor) which combining static methods and values.
- not a util class(JAVA conception),often associated with its ***companions***,
  a class with same name as object in ***same file***
- My Understanding in JAVA world: static methods and values for a Class

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
decorator like??

- ```apply``` like a constructor
- ```unapply``` takes an object and give back to arguments
- it really confused me

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

- Quit similar with JAVA Generic.

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