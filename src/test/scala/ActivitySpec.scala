import model.Activity
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec

class ActivitySpec extends AnyWordSpec with Matchers{
  val duration = 1.3
  val distance = 10
  val name = "Feli"
  val activityName = "running"
  /*val activity = new Activity(Some(name), Some(activityName), Some(distance), Some(duration))

  "An Activity" when{
    "copy all of" in{
      activity.Of(name) should be(activity)
    }
    "copy all is" in{
      activity.Is(activityName) should be(activity)
    }
    "copy all for" in{
      activity.For(distance) should be(activity)
    }
    "copy all in" in{
      activity.In(duration) should be(activity)
    }

  }*/
}
