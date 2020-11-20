package model
import scala.util.parsing.combinator.RegexParsers

class ActivityParser extends RegexParsers{

  def userName = "[a-zA-zäÄöÖüÜß]+".r
  def activityName = "(joggte)|(wanderte)|(spazierte)".r
  def distance = "[0-9]+(.[0-9]+)?".r
  def distanceUnit = "km".r
  def In = "in".r
  def duration = "[0-9]+(.[0-9]+)?".r
  def durationUnit = "(min)|(h)".r
  def text = "[a-zA-zäÄöÖüÜß\\s]+:".r
  def userGroup = "([a-zA-zäÄöÖüÜß]+,\\s*)*[a-zA-zäÄöÖüÜß]+".r

  def activityParser: Parser[Activity] =
   userName ~ activityName ~ distance ~ distanceUnit ~ In ~ duration ~ durationUnit ^^ {
    case userName ~ activityName ~ distance ~ _ ~ _ ~ duration ~ _ =>
      {
        val activity = Activity(userName, activityName, distance.toDouble, duration.toDouble)
        activity
      }
  }

  def userGroupParser : Parser[Competition] =
    text ~ userGroup ^^ {
      case _ ~ userGroup => {
        val userList = userGroup.split(",\\s").toSeq
        Competition(userList)
      }
    }


}
