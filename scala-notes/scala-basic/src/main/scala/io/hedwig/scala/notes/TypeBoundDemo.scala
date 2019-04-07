package io.hedwig.scala.notes

/**
  * 1. author: patrick
  */
object TypeBoundDemo extends App {
  abstract class Animal {
    def name:String
  }

  abstract class Pet extends Animal{}
  class Cat extends Pet{
    override def name: String = "CAT"
  }
  class Dog extends Pet{
    override def name: String = "DOG"
  }

  class Lion extends Animal {
    override def name: String = "Lion"
  }

  class PetContainer[P <: Pet](p: P) {
    def pet: P = p
  }

  val dogContainer = new PetContainer[Dog](new Dog)
  val catContainer = new PetContainer[Cat](new Cat)

}


