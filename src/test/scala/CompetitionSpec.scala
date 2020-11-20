import model.Activity
import model.Competition
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec

class CompetitionSpec extends AnyWordSpec with Matchers{
  val Feli= "Feli"
  val Paul = "Paul"
  val Sebi = "Sebi"
  val userGroup = Seq(Feli, Paul, Sebi)
  val competition = new Competition(Seq( Feli, Paul ,Sebi))
  val duration = 1.3
  val distance = 10
  val name = "Feli"
  val activityName = "running"
  val activity = new Activity(name, activityName, distance, duration)
  val activity1 = new Activity("Sebi", "walking", 5, 0.5)
  val activity2 = new Activity("Paul", "hiking", 9, 2)
  val activity3 = new Activity("Sebi","walking", 2, 0.3)
  val activity4 = new Activity("Paul", "hiking", 2, 0.3)
  val list_of_activities = List(activity, activity1, activity2, activity3, activity4)


  "A Competition" when{
    "returning sorted list" in{
      competition.getSortedList(list_of_activities) should be(Seq(Seq(activity), Seq(activity2, activity4), Seq(activity1, activity3)) )
    }

    "return a list with sums of users" in{
      competition.getSumForUser(Seq(Seq(activity), Seq(activity2, activity4), Seq(activity1, activity3)), 0) should be(10)
    }

    "returning a sorted list with name and sum" in{
      competition.addsAndSortsUserNameToList(Seq(10.0, 11, 7)) should be(Seq(("Paul", 11), ("Feli", 10.0), ("Sebi", 7)))
    }

    "returning string for score board" in{
      val sumOfUser = userGroup.map(user => competition.getSumForUser(competition.getSortedList(list_of_activities), userGroup.indexOf(user)))
      val scoreBoard = competition.addsAndSortsUserNameToList(sumOfUser)
      competition.stringToPrintScoreBoard(scoreBoard) should be("1. Paul did 11.0 km\n" + "2. Feli did 10.0 km\n" + "3. Sebi did 7.0 km\n")
    }
  }
}
