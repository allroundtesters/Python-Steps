package io.hedwig.scala.notes

/**
  * 1. author: patrick
  */
trait CompoundDemo extends Cloneable {
  override def clone(): Cloneable = {
    super.clone().asInstanceOf[Cloneable]
  }
}
trait Resetable {
  def reset:Unit
}

