package model
import scala.util.parsing.combinator.RegexParsers

class ActivityParser extends RegexParsers{

  def parseDSL(input:String): ParseResult[Activity] =
    parse(activityParser, input)


  def activityParser: Parser[Activity] =
    "Activity:" ~ userName ~
      "did" ~ activityName ~
      "for" ~ distance ~ "km in" ~ duration ~ "h" ^^ {
    case _ ~ user ~ _ ~ activity ~ _ ~ distance ~ _ ~ duration ~ _ =>
      Activity(user, activity, distance, duration)
  }

  def userName: Parser[String] =
    "[^\\v]+".r ^^ (_.toString)

  def activityName: Parser[String] =
    """[^\v]+""".r ^^ (_.toString)

  def distance: Parser[Double] =
    """\d+(\.\d+)?""".r ^^ (_.toDouble)

  def duration: Parser[Double] =
    """\d+(\.\d+)?""".r ^^ (_.toDouble)
}
