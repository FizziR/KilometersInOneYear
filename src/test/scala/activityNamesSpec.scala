import model.activityNames
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec


class activityNamesSpec extends AnyWordSpec  with Matchers {
  "In a Competition, there are many activities:" when{
    "a person runs the activity name has to be equal" in{
      activityNames.running should be("running")
    }
    "a person hikes the activity name has to be equal" in{
      activityNames.hiking should be("hiking")
    }
    "a person walks the activity name has to be equal" in{
      activityNames.walking should be("walking")
    }
  }

}
