package model

case class Activity(userName: Option[String], activityName: Option[String],  distance: Option[Double], duration: Option[Double]) {

  def Of(userName_ : String): Activity ={
    copy(Some(userName_), activityName, distance, duration)
  }
  def Is(activityName_ :String): Activity ={
    copy(userName, Some(activityName_), distance, duration)
  }
  def For(distance_ : Double): Activity ={
    copy(userName, activityName, Some(distance_), duration)
  }
  def In(duration_ : Double): Activity ={
    copy(userName, activityName, distance, Some(duration_))
  }

}
