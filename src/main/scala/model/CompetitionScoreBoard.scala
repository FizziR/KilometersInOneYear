package model
import model.Activity
import model.Competition
import model.activityNames.{running, hiking, walking}
import implicit_conversion.implicitConversion._

object CompetitionScoreBoard {
  def main(args: Array[String]): Unit = {


    val Feli = "Feli"
    val Paul = "Paul"
    val Sebi = "Sebi"


    val WhoRanMoreKilometers = Competition(userGroup = Feli, Paul, Sebi)

    val activity = Activity(None, None, None, None)
    val scoreBoard = WhoRanMoreKilometers getScoreBoard(
      activity Of Feli Is running For 10.KM In 1.3.H,
      activity Of Paul Is walking For 2.KM In 30.MIN,
      activity Of Sebi Is hiking For 6.M In 1.5.H,
    )

    print(WhoRanMoreKilometers.stringToPrintScoreBoard(scoreBoard))

  }


}
