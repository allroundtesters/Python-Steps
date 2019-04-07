/**
  * @@author: patrick
  */
object Invoker {
  private var history: Seq[() => Unit] = Seq.empty

  def invoke(command: => Unit) { // by-name parameter
    command
    history :+= command _
  }

  def printHistory={
    println(history)
  }
}

object CommandMain{
  def main(args: Array[String]): Unit = {
    Invoker.invoke(println("foo"))

    Invoker.invoke {
      println("bar 1")
      println("bar 2")
    }
    Invoker.printHistory
  }
}

