package io.hedwig.scala.notes.oo

/**
  * 1. author: patrick
  * A Generic Class for a Stack
  */
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

  class Foo[+A] // A covariant class
  class Bar[-A] // A contravariant class
  class Baz[A]  // An invariant class
}

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
