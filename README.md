# KilometersInOneYear
This is a project to learn how to create and use internal and external DSLs as well as implicit conversions and streams.
It is a programm to document the activities running, walking and hiking of a family or group of friends over a specific period of time.
With the documentation of the differenten activities the programm generates the sum of the kilometers of each user over the time and prints a score board with all participants and their kilometer values.
The internal and external DSLs are used to convert the setences to variables. 

## This projects consists of different branches:
- main: uses internal DSL
- ##### feature/impliciteConversion: uses internal DSL with the addition of an implicite conversion
- feature/externalDSL: uses external DSL 
- feature/AkkaStreams: uses external DSL with the addition of an implicite conversion

## feature/internalDSLinUser
In this programm the internal DSL of the main-branche is extended by the implicit conversion.
That changes in the input of new activities in the main function by adding the unit of the distance and duration.
For distances participants can use the units KM and M, for the durations the possible units are H and MIN as you can see in the implicitConversion.scala file
The actual inout looks like this: activity Of <username> Is <activity> For <distance.DistanceUnit> In <duration.TimeUnit>
The distances of the different users are all converted to kilometers and the durations to hours for the calcuation of the score board.

[![Build Status](https://travis-ci.com/FizziR/KilometersInOneYear.svg?branch=feature/internalDSLinUser)](https://travis-ci.com/FizziR/KilometersInOneYear) [![Coverage Status](https://coveralls.io/repos/github/FizziR/KilometersInOneYear/badge.svg?branch=main)](https://coveralls.io/github/FizziR/KilometersInOneYear?branch=feature/internalDSLinUser)
