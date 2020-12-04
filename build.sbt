name := "KilometersInOneYear"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.2"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"

val akkaVersion = "2.6.5"

libraryDependencies ++= Seq(
  // akka streams
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
)
