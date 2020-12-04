
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec
import scala.util.parsing.combinator.RegexParsers

class ActivityParserModelSpec extends AnyWordSpec with Matchers {

  val activityParserModel = new ActivityParserModel
  val activityList = List("Feli spazierte 7.5 km in 1.5 h")
  val competition = activityParserModel.generateCompetitionFromString("Teilnehmer: Feli, Sebi, Paul")
  val listOfActivities = activityParserModel.generateActivitiesFromStrings(List("Feli spazierte 7.5 km in 1.5 h", "Sebi spazierte 8.5 km in 1.5 h", "Paul spazierte 9.5 km in 1.5 h"))

  "The ActivityParserModel extends the ActivityParser by calling the parser function and controlling the success of it" when{
    "the parse should be successful" in{
      activityParserModel.generateActivitiesFromStrings(activityList) should be(List(Some( Activity("Feli", "spazierte", 7.5, 1.5))))
      activityParserModel.generateActivitiesFromStrings(List("Feli spazieren 7.5 km in 1.5 h")) should be(List(None))
    }
    "the parse of activity should be successful" in{
      activityParserModel.generateCompetitionFromString("Teilnehmer: Feli, Paul, Sebi") should be(Some(Competition(Seq("Feli", "Paul", "Sebi"))))
      activityParserModel.generateCompetitionFromString("Teilnehmer dshfkfskdk jdksfj sdfkjd") should be(None)
    }

    "should return score board" in{
      activityParserModel.getScoreBoard(competition, listOfActivities) should be("1. Paul did 9.5 km\n" + "2. Sebi did 8.5 km\n" + "3. Feli did 7.5 km\n")
    }
  }

}
