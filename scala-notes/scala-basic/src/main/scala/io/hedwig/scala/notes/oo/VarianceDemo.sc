//Covariance List[+A]
// A is subtype of B,List[A] is subtype of List[B]

abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal

case class Dog(name: String) extends Animal

//As abstract class List[+A]
// So List[Cat] List[Dog] is also List[Animal]

def printAnimalName(animals: List[Animal]): Unit = {
  animals.foreach(
    animal => println(animal)
  )
}
val cats: List[Cat] = List(Cat("cat1"), Cat("cat2"))
val dogs: List[Dog] = List(Dog("dog1"), Dog("dog2"))

printAnimalName(cats)
printAnimalName(dogs)

//Contravariance

abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  override def print(animal: Animal): Unit = {
    println("The animal's name is " + animal.name)
  }
}

class CatPrinter extends Printer[Cat] {
  override def print(value: Cat): Unit = {
    println("The Cat's name is " + value.name)
  }
}

val catPrinter: Printer[Cat] = new CatPrinter
val animalPrinter: Printer[Animal] = new AnimalPrinter
val myCat = Cat("Cat23")

def printMyCat(printer: Printer[Cat]): Unit = {
  printer.print(myCat)
}

printMyCat(catPrinter)
printMyCat(animalPrinter) //supertype also valid

//invariance
class Container[A](value: A) {
  private var _value: A = value

  def getValue: A = _value

  def setValue(Value: A): Unit = {
    _value = value
  }
}

val catContainer:Container[Cat]=new Container[Cat](Cat("Felix"))
val animalContainer:Container[Animal]=new Container[Animal](Cat("Cat"))
animalContainer.setValue(Dog("Dog"))
//val cat:Cat=animalContainer.getValue //ops,Dog is never be a Cat

//Function1[-T,+R]
abstract class SmallAnimal extends Animal
abstract class Mouse extends SmallAnimal

// Animal=>Mouse is subtype of Cat=>SmallAnimal
//todo to understand more


