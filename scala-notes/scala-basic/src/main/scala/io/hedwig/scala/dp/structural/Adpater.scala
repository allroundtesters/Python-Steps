import java.util.logging.Level

/**
  * @@author: patrick
  */

trait Log {
  def warn(message:String)
  def log(message:String)
  def error(message:String)
}

final class Logger {
  def log(level:Level,message:String): Unit ={
    println(message)
  }
}


implicit class LoggerToLogAdapter(logger: Logger) extends Log {
  def warning(message: String) { logger.log(WARNING, message) }
  def error(message: String) { logger.log(ERROR, message) }
}

val log: Log = new Logger()