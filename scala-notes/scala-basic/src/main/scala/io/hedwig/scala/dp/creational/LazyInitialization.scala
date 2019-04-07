package io.hedwig.scala.dp.creational

/**
  * @@author: patrick
  */

object LazyInitialization{
  def main(args: Array[String]): Unit = {
    lazy val x ={
      println("(computing x)")
      42
    }
    val y = {
      println("is ")
      43
    }
    print("x = ")
    println(x)
    println("y=")
    println(y)
  }
}