
case class Competition(userGroup: Seq[String]){

  val database = collection.mutable.Map[String, Double]()
  userGroup.foreach(user => database += (user -> 0.0))

  def getScoreBoard(listOfDatabase : List[(String, Double)]) ={

    val scoreBoard = sortsList(listOfDatabase)
    val stringScoreBoard = stringToPrintScoreBoard(scoreBoard)
    stringScoreBoard
  }


  def sortsList(listOfSums: List[(String, Double)]): Seq[(String, Double)] ={
    val sortedSumList = listOfSums.sortBy(_._2)(Ordering[Double].reverse)
    sortedSumList
  }

  def stringToPrintScoreBoard(scoreBoard: Seq[(String, Double)])={
    var emptyString = ("")
    scoreBoard.foreach(score => emptyString += {s"${scoreBoard.indexOf(score)+1}. ${score._1} did ${score._2} km\n"})
    emptyString
  }

  def addActivityToUser(activity: Option[Activity])={
    database(activity.get.userName) = database(activity.get.userName) + activity.get.distance

    val listOfDatabase = database.toList
    print("Update:\n" + getScoreBoard(listOfDatabase) + "\n")
  }


}

