package io.hedwig.scala.notes.functional

/**
  * 1. author: patrick
  */


class Decorator(left: String, right: String) {
  def layout[A](x: A) = left + x.toString + right
}
//High-Order Function

object FuncDemo extends App{
  //function as parameter
  def apply(f: Int => String, v: Int) = f(v)
  val decorator = new Decorator("[","]")
  println(apply(decorator.layout,7))
}


////nested function
//def factorial(x: Int): Int = {
//  def fact(x: Int, accumulator: Int): Int = {
//    if (x <= 1) accumulator
//    else fact(x - 1, x * accumulator)
//  }
//  fact(x, 1)
//}
//
//object Main{
//  def main(args: Array[String]): Unit = {
//    println(factorial(12))
//  }
//}