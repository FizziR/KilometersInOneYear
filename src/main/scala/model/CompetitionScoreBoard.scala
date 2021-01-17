package model

import model.activityNames.{running, hiking, walking}

object CompetitionScoreBoard {
  def main(args: Array[String]): Unit = {


    val Feli = "Feli"
    val Paul = "Paul"
    val Sebi = "Sebi"


    val WhoRanMoreKilometers = Competition(userGroup = Feli, Paul, Sebi)

    val activity = Activity(None, None, None, None)
    val scoreBoard = WhoRanMoreKilometers getScoreBoard(
      activity Of Feli Is running For 10 In 1.3,
      activity Of Paul Is walking For 2 In 0.5,
      activity Of Sebi Is hiking For 6 In 1.5,
    )

    print(WhoRanMoreKilometers.stringToPrintScoreBoard(scoreBoard))

  }


}
