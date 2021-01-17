# KilometersInOneYear

## feature/internalDSLinUser
In this programm the internal DSL of the main-branche is extended by the implicit conversion.
That changes in the input of new activities in the main function by adding the unit of the distance and duration.
For distances participants can use the units KM and M, for the durations the possible units are H and MIN as you can see in the implicitConversion.scala file
The actual inout looks like this: activity Of <username> Is <activity> For <distance.DistanceUnit> In <duration.TimeUnit>
The distances of the different users are all converted to kilometers and the durations to hours for the calcuation of the score board.
