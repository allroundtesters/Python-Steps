package io.hedwig.scala.notes.basicOfBasic

/**
  * @@author: patrick
  */
class MicroWave{
  def start() = println("start")
  def end() = println("end")
}

object RunnerObject{
  def main(args: Array[String]): Unit = {
    val microWave = new MicroWave
    microWave.start()
    microWave.end()
  }
}