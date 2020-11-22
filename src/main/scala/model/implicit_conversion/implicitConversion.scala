package model.implicit_conversion

import scala.concurrent.duration.Duration


object implicitConversion {

  class DistanceUnit(distance: Double) {

    def KM = distance

    def M = (distance / 1000).toDouble

  }

  implicit def fromDoubleToDistance(distance: Double) = new DistanceUnit(distance)

  class TimeUnit(duration: Double){
    def H = duration
    def MIN = (duration/60).toDouble
  }
  implicit def fromDoubleToDuration(duration: Double)= new TimeUnit(duration)

}