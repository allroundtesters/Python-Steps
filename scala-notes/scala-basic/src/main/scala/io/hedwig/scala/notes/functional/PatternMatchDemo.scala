package io.hedwig.scala.notes.functional

import scala.util.Random

/**
  * 1. author: patrick
  */
object Mix extends App {

  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(sender: String, msg: String) extends Notification

  case class VoiceMail(sender: String, link: String) extends Notification

  // case class pattern match
  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceMail(name, link) =>
        s"you received a Voice Mail from $name! Click the link to hear it: $link"
    }
  }

  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceMail("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms)) // prints You got an SMS from 12345! Message: Are you there?

  println(showNotification(someVoiceRecording)) // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
  def matchTest(x: Int): String = x match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
    case _ => "more than three"
  }

  val x: Int = Random.nextInt(10)

  x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  println(x)
  matchTest(3)
  matchTest(1)

  //matching on type only
  abstract class Device

  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }

  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on"
  }

  //depends of type of class
  def goIdle(device: Device) = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }

  //sealed classes
  //Traits and classes can be marked sealed which means all subtypes must be declared in the same file.
  // This assures that all subtypes are known.
  sealed abstract class Furniture

  case class Couch() extends Furniture

  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Site on the chair"
  }
}

