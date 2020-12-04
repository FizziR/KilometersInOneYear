import akka.actor.ActorSystem
import akka.stream.scaladsl.{Flow, Sink, Source}


object CompetitionScoreBoard {
  def main(args: Array[String]): Unit = {

    val input_txt = io.Source.fromFile("./src/competition.txt").getLines.toList
    val activityParseModel = new ActivityParserModel()
    val userGroup = activityParseModel.generateUserGroupFromString(input_txt(4)).get

    implicit val system = ActorSystem("Main-System")

    val userSource = Source(input_txt.drop(6))
    val userFlow = Flow[String].map(activity => activityParseModel.generateActivityFromString(activity))
    val sink = Sink.foreach[Option[Activity]](Competition(userGroup).addActivityToUser)

    val activityStream = userSource.via(userFlow).to(sink)
    activityStream.run()

    val competition = activityParseModel.generateCompetitionFromString(input_txt(4))
    val input_activities = input_txt.drop(6)
    val activity_list = activityParseModel.generateActivitiesFromStrings(input_activities)
    val scoreBoard = activityParseModel.getScoreBoard(competition, activity_list)

    //print(scoreBoard)

  }


}
