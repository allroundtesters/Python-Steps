package io.hedwig.scala.notes.oo

import scala.util.Random

/**
  * 1. author: patrick
  */

object CustomID {
  def apply(name:String) =s"$name--${Random.nextLong}"
  def unapply(customerID: String): Option[String] = {
    val name = customerID.split("--").head
    if (name.nonEmpty) Some(name) else None
  }
}

object CustomIDMain{
  def main(args: Array[String]): Unit = {
    val customer1ID = CustomID("abcdkid")
    customer1ID match {
      case CustomID(name)=>{
        println(customer1ID)
        println(name) //
      }
      case _=>println("Could not extract a CustomerID")
    }

    val customer2ID=CustomID("efkid")
    println(customer2ID)
    val CustomID(name) = customer2ID
    println(CustomID.unapply(customer2ID).get)
    println(name)
  }
}



