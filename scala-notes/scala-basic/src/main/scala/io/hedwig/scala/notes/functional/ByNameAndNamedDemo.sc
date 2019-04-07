//by name not by value
def calculate(input: => Int) = input * 37

def whileLoop(condition: => Boolean)(body: => Unit): Unit =
  if (condition) {
    body
    whileLoop(condition)(body)
  }

var i = 2
whileLoop(i > 0) {
  println(i)
  i -= 1
}


//default parameter value and named parameter

def log(msg: String, level: String = "INFO"): Unit = {
  println(s"$msg-$level")
}


def printName(first: String, last: String): Unit = {
  println(first + " " + last)
}

printName("John", "Smith")  // Prints "John Smith"
printName(first = "John", last = "Smith")  // Prints "John Smith"
printName(last = "Smith", first = "John")  // Prints "John Smith"


def listOfDuplicates[A](x: A, length: Int): Unit =
  if (length < 1)
    println("Noting")
  else
    x::listOfDuplicates(x, length - 1)
println(listOfDuplicates[Int](3, 4))  // List(3, 3, 3, 3)
println(listOfDuplicates("La", 8))  // List(La, La, La, La, La, La, La, La)