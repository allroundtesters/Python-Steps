package io.hedwig.scala.notes.support
import org.scalatest.Stopper

/**
  * 1. author: patrick
  */
object Master extends Stopper{
  var studentNeedsToMeditate = false

  def apply() =false

  override def stopRequested: Boolean = {
    true
  }

  override def requestStop(): Unit = {
    true
  }
}
