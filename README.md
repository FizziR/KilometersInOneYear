# KilometersInOneYear
This is a project to learn how to create and use internal and external DSLs as well as implicit conversions and streams.
It is a programm to document the activities running, walking and hiking of a family or group of friends over a specific period of time.
With the documentation of the differenten activities the programm generates the sum of the kilometers of each user over the time and prints a score board with all participants and their kilometer values.
The internal and external DSLs are used to convert the setences to variables. 

## This projects consists of different branches:
- main: uses internal DSL
- feature/impliciteConversion: uses internal DSL with the addition of an implicite conversion
- feature/externalDSL: uses external DSL 
- #### feature/AkkaStreams: uses external DSL with the addition of an implicite conversion

## featrue/AkkaStreams-branche:
In this branche the external DSL is implemented and extended by AkkaStream.
The activities of .txt-file beginning in line 6 are the source of the stream. 
The flow takes each activity (in this case each line of the .txt-file) by mapping through the acrtivities. Each activity is then parsed indiviually by the ActicitiyParser. In the sink, there is a Map including the usernames as keys and the sums of the achieved kilometers of the users as values.
In the sink, the scoreboard gets updated and printed each time a new activity got parsed. 

The testing also covers the akka streams by using the scaladsl testsink of the testkit of akka streams.

[![Build Status](https://travis-ci.com/FizziR/KilometersInOneYear.svg?branch=feature/AkkaStreams)](https://travis-ci.com/FizziR/KilometersInOneYear) [![Coverage Status](https://coveralls.io/repos/github/FizziR/KilometersInOneYear/badge.svg?branch=feature/AkkaStreams)](https://coveralls.io/github/FizziR/KilometersInOneYear?branch=main)
