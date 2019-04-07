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

//compare with structure
val email1=new Email("sender","title","body")
val email2=new Email("sender","title","body")
val sameEmail=email1==email2
//copy
val email3 = email2.copy(sender = "test")
println(s"$email3.sender $email3.body $email3.title")

val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceMail("Tom", "voicerecording.org/id/123")

println(showNotification(someSms)) // prints You got an SMS from 12345! Message: Are you there?

println(showNotification(someVoiceRecording))