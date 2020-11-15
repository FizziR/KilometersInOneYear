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
  "A Competition" when{

  }
}
