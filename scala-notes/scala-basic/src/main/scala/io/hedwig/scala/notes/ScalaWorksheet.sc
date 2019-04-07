println("Hello World")
println(1)
println(1 + 1)
// values can not re-assigned
val x = 1 + 1
println(x)
//type of values
val y: Int = 2 + 3
println(y)
print("abc".size)
//variable
var z = 1 + 1
println(x * x)
"abc" + 4
4 + "1.0"
5 < 6
Nil
//if(0){ //error here
//  println("this is")
//}
var person=("Hello","World")
println(person)
println(person._1)
println(person._2)
val (a,b) =(1,3)
var (c,d) = (4,5)
//Blocks
println({
  val x = 1 + 1
  x + 1
})

//Functions
val addOne = (x: Int) => x + 1
println(addOne(2))

val sumFunc = (x: Int, y: Int) => x + y
println(sumFunc(12, 34))

val getIt = () => 44
println(getIt())

//methods
def add(x: Int, y: Int): Int = x + y

println(add(3, 8))

def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
println(addThenMultiply(12, 34)(12))

def name: String = System.getProperty("name", "name")
println("Hello," + name + "!")

def getSquareString(input: Double): String = {
  var square = input * input
  square.toString
}
println(getSquareString(144))

//Class,Case Class,Objects:Singleton

//scala types

val arrList: List[Any] = List(
  "a string",
  4345,
  'c',
  true,
  () => "this is function"
)

arrList.foreach(element => println(element))

//Nothing: a subtype of all types,bottom type
// Null: Null is a subtype of all reference types

//case class, new never used for case class,because there is apply method
// for object construction
case class Book(isbn:String)
val book1=Book("901223")
println(book1.isbn) // parameter are public
//case class comparison by structure not reference
case class Message(sender: String, recipient: String, body: String)

val message2 = Message("misc1@163.com", "misc1@163.com", "Com va?")
val message3 = Message("misc1@163.com", "misc1@163.com", "Com va?")
val messagesAreTheSame = message2 == message3  // true

//case class copy

case class CMessage(sender: String, recipient: String, body: String)
val message4 = CMessage("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
message5.sender  // travis@washington.us
message5.recipient // claire@bourgogne.fr
message5.body  // "Me zo o komz gant ma amezeg"

//pattern match
