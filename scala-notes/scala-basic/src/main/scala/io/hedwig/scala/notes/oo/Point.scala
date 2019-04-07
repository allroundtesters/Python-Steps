package io.hedwig.scala.notes.oo

/**
  * 1. author: patrick
  */
class Point(prefix:String,suffix:String) {
  private var _x=0
  private var _y=0
  private val bound=100

  private def printWarning = println("WARNING:out of bounds")
  def x=_x
  def x_=(newValue:Int):Unit={
    if(newValue<bound) _x = newValue else printWarning
  }
  def y=_y
  def y_=(newValue: Int):Unit={
    if(newValue<bound) _x = newValue else printWarning
  }
  def move_forword(step:Int): Unit ={
    _x+=step
    _y+=step
  }

  def back(step:Int): Unit ={
    _x-=step
    _y-=step
  }

  def location: Unit = {
    (_x,_y)
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    var p = new Point("A","B")
    p.move_forword(11)
    p.back(1)
    println(p.location)
    println(p.x)
    println(p.y)
  }
}