package model

case class Competition(userGroup: String*){


  def getScoreBoard( listOfActivities: Activity*) ={
    val emptyList = getEmptySeq(userGroup)
    val sortedList = getSortedList(listOfActivities)
    val sumOfUsers = userGroup.map(user => getSumForUser(sortedList, userGroup.indexOf(user)))
    val scoreBoard = addsAndSortsUserNameToList(sumOfUsers)
    scoreBoard
  }

  def getEmptySeq(users: Seq[String]):Vector[Double]={
    Vector.fill(users.length)(0)
  }

  def getSortedList(listOfActivities: Seq[Activity]):Seq[Seq[Activity]]={

    val sortedListOfActivities= userGroup.map(user => { listOfActivities.filter(activity => (activity.userName.get ==user))})
    sortedListOfActivities
  }
  def getSumForUser(sortedList: Seq[Seq[Activity]], userIndex: Int): Double ={
    val ListOfKilometer = sortedList(userIndex).map(n => n.distance.get)
    val sumOfKilometer = ListOfKilometer.sum
    sumOfKilometer
  }
  def addsAndSortsUserNameToList(listOfSums: Seq[Double]): Seq[(String, Double)] ={
    val listWithSumAndName = listOfSums.map(sum => (userGroup(listOfSums.indexOf(sum)), sum))
    val sortedSumList = listWithSumAndName.sortBy(_._2)(Ordering[Double].reverse)
    sortedSumList
  }

  def stringToPrintScoreBoard(scoreBoard: Seq[(String, Double)])={
    var emptyString = ("")
    scoreBoard.foreach(score => emptyString += {s"${scoreBoard.indexOf(score)+1}. ${score._1} did ${score._2} km\n"})
    emptyString
  }



}
