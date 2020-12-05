import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec

import scala.collection.immutable.HashMap

class CompetitionSpec extends AnyWordSpec with Matchers{
  val listOfDatabase = List(("Feli", 10.0), ("Paul", 15.3), ("Sebi", 12.7))
  val competition = Competition(Seq("Feli", "Paul", "Sebi"))
  val database = collection.mutable.Map[String, Double]()
  val userGroup = Seq("Feli", "Paul", "Sebi")
  userGroup.foreach(user => database += (user -> 0.0))
  val activity = Activity("Feli", "spazierte", 6.0, 1.2)


  "A Competition" when{

    "returning string for score board" in{
      val sortedList = competition.sortsList(listOfDatabase)
      competition.stringToPrintScoreBoard(sortedList) should be("1. Paul did 15.3 km\n" + "2. Sebi did 12.7 km\n" + "3. Feli did 10.0 km\n")
    }
    "returning sorted list" in{
      competition.sortsList(listOfDatabase) should be(List(("Paul", 15.3), ("Sebi", 12.7), ("Feli", 10.0)))
    }
    "updating rhe database" in{
      competition.addActivityToUser(Option(activity))
      database should be (HashMap("Feli" -> 0.0, "Paul" -> 0.0, "Sebi" -> 0.0))
    }
  }
}
