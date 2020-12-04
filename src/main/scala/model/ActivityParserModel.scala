
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
  def generateActivitiesFromStrings(input_activity_string : List[String]) :List[Option[Activity]] ={
    input_activity_string.map(activity =>
      parse(activityParser, activity) match {
        case Success(value, _) => Some(value)
        case Failure(msg, _) => {
          println(s"$failure: $msg")
          None
        }
        case Error(msg, _) => {
          println(s"$error: $msg")
          None
        }
      }
    )
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

  def generateCompetitionFromString(lineWithUsers : String): Option[Competition]={
    parse(CompetitionParser, lineWithUsers) match{
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

  def getScoreBoard(competition: Option[Competition], activity_list: List[Option[Activity]]): String ={
    if(competition.isDefined)  {
      if(activity_list.forall(_.isDefined)) {
        competition.get.getScoreBoard(activity_list.map(activity => activity.get))
      }
      else "activity_list is not defined"
    }
    else "competition is not defined"
  }

}
