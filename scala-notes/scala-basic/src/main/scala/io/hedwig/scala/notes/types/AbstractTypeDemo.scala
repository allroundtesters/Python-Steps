package io.hedwig.scala.notes.types

/**
  * 1. author: patrick
  */

trait Buffer {
  type T
  val element:T
}

abstract class SeqBuffer extends Buffer{
  type U
  type T <: Seq[U]
  def length = element.length
}