package model
import scala.io.Source

object CompetitionScoreBoard {
  def main(args: Array[String]): Unit = {

    val input_txt = Source.fromFile("./src/competition.txt").getLines.toList
    val activityParseModel = new ActivityParserModel()
    val competition = activityParseModel.generateCompetitionFromString(input_txt(4))
    val input_activities = input_txt.drop(6)
    val activity_list = activityParseModel.generateActivitiesFromStrings(input_activities)
    val scoreBoard = activityParseModel.getScoreBoard(competition, activity_list)

    print(scoreBoard)

  }


}
