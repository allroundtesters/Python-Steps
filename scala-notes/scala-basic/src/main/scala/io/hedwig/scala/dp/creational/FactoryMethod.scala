package io.hedwig.scala.dp.creational

/**
  * @@author: patrick
  */

trait Animal
private class Dog extends Animal
private class Cat extends Animal

object Animal {
  def apply(kind:String): Animal =kind match {
    case "dog"=>new Dog()
    case "cat"=>new Cat()
  }
}

object FactoryMethod{
  def main(args: Array[String]): Unit = {
   val dog:Animal = Animal("dog")
    println(dog.getClass.getSimpleName)
  }
}