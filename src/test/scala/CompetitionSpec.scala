import model.Activity
import model.Competition
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec

class CompetitionSpec extends AnyWordSpec with Matchers{
  val Feli= "Feli"
  val Paul = "Paul"
  val Sebi = "Sebi"
  val competition = new Competition(userGroup = Feli,Paul ,Sebi)
  val duration = 1.3
  val distance = 10
  val name = "Feli"
  val activityName = "running"
  val activity = new Activity(Some(name), Some(activityName), Some(distance), Some(duration))
  val activity1 = new Activity(Some("Sebi"), Some("walking"), Some(5), Some(0.5))
  val activity2 = new Activity(Some("Paul"), Some("hiking"), Some(9), Some(2))
  val activity3 = new Activity(Some("Sebi"), Some("walking"), Some(2), Some(0.3))
  val activity4 = new Activity(Some("Paul"), Some("hiking"), Some(2), Some(0.3))
  val listOfActivities: Seq[Activity] = Seq(activity, activity1, activity2, activity3, activity4)
  val scoreBoard = competition.getScoreBoard(activity, activity1, activity2,activity3, activity4)
  "A Competition" when{
    "returning sorted list" in{
      competition.getSortedList(listOfActivities) should be(Seq(Seq(activity), Seq(activity2, activity4), Seq(activity1, activity3)) )
    }

    "return a list with sums of users" in{
      competition.getSumForUser(Seq(Seq(activity), Seq(activity2, activity4), Seq(activity1, activity3)), 0) should be(10)
    }

    "returning a sorted list with name and sum" in{
      competition.addsAndSortsUserNameToList(Seq(10.0, 11, 7)) should be(Seq(("Paul", 11), ("Feli", 10.0), ("Sebi", 7)))
    }

    "returning string for score board" in{
      competition.stringToPrintScoreBoard(scoreBoard) should be("1. Paul did 11.0 km\n" + "2. Feli did 10.0 km\n" + "3. Sebi did 7.0 km\n")
    }
  }
}
