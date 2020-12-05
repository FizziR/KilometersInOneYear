
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec
import scala.util.parsing.combinator.RegexParsers

class ActivityParserModelSpec extends AnyWordSpec with Matchers {

  val activityParserModel = new ActivityParserModel
  val activityString = "Feli spazierte 7.5 km in 1.5 h"
  val userGroup = activityParserModel.generateUserGroupFromString("Teilnehmer: Feli, Sebi, Paul")
  val activity = activityParserModel.generateActivityFromString("Feli spazierte 7.5 km in 1.5 h")
  "The ActivityParserModel extends the ActivityParser by calling the parser function and controlling the success of it" when{
    "the parse should be successful" in{
      activityParserModel.generateActivityFromString(activityString) should be(Some( Activity("Feli", "spazierte", 7.5, 1.5)))
      activityParserModel.generateActivityFromString("Feli spazieren 7.5 km in 1.5 h") should be(None)
    }
    "the parse of activity should be successful" in{
      activityParserModel.generateUserGroupFromString("Teilnehmer: Feli, Paul, Sebi") should be(Some(Seq("Feli", "Paul", "Sebi")))
      activityParserModel.generateUserGroupFromString("Teilnehmer dshfkfskdk jdksfj sdfkjd") should be(None)
    }
  }
}
