package io.hedwig.scala.dp.creational

/**
  * @@author: patrick
  */
object Cat extends Runnable {

  override def run(): Unit = {
    println("running")
  }
}

object SingletonMain{
  def main(args: Array[String]): Unit = {
    Cat.run()
  }
}

