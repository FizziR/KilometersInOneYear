package model

import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec


class ActivityParserSpec extends AnyWordSpec with Matchers {

  val activityParser = new ActivityParser
  "An ActivityParser" when{
    "regular expressions" in{
      "Feli".matches(activityParser.userName.regex) should be(true)
      "Feli110".matches(activityParser.userName.regex) should be(false)

      "joggte".matches(activityParser.activityName.regex) should be(true)

      "9.66".matches(activityParser.distance.regex) should be(true)

      "km".matches(activityParser.distanceUnit.regex) should be(true)

      "in".matches(activityParser.In.regex) should be(true)

      "1.5".matches(activityParser.duration.regex) should be(true)

      "h".matches(activityParser.durationUnit.regex) should be(true)

      "mdfjksfhs slfjsdlfjsdlf :".matches(activityParser.text.regex) should be(true)

      "Feli, Lukas, Paul".matches(activityParser.userGroup.regex) should be(true)
      "Feli, Lukas, Paul,".matches(activityParser.userGroup.regex) should be(false)

    }
    
  }
}
