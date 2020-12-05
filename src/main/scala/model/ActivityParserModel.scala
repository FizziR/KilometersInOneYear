
import scala.util.parsing.combinator.RegexParsers

class ActivityParserModel extends ActivityParser {
  val failure = "Failure"
  val error = "Error"

  def generateActivityFromString(input_activity_string : String) :Option[Activity] ={
    parse(activityParser, input_activity_string) match{
        case Success(value, _) => Some(value)
        case Failure (msg, _) => {
          println(s"$failure: $msg")
          None
        }
        case Error (msg, _)  => {
          println(s"$error: $msg")
          None
        }
    }
  }

  def generateUserGroupFromString(lineWithUsers : String): Option[Seq[String]]={
    parse(userGroupParser, lineWithUsers) match{
      case Success(value, _) => Some(value)
      case Failure (msg, _) => {
        println(s"$failure: $msg")
        None
      }
      case Error (msg, _)  => {
        println(s"$error: $msg")
        None
      }
    }

  }
}
