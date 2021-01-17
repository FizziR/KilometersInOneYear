# KilometersInOneYear
This is a project to learn how to create and use internal and external DSLs as well as implicit conversions and streams.
It is a programm to document the activities running, walking and hiking of a family or group of friends over a specific period of time.
With the documentation of the differenten activities the programm generates the sum of the kilometers of each user over the time and prints a score board with all participants and their kilometer values.
The internal and external DSLs are used to convert the setences to variables. 

## This projects consists of different branches:
- #### main: uses internal DSL
- feature/impliciteConversion: uses internal DSL with the addition of an implicite conversion
- feature/externalDSL: uses external DSL 
- feature/AkkaStreams: uses external DSL with the addition of an implicite conversion

## main-branche:
In this branche the internal DSL is implemented to convert the sentences wirtten in the main class to variables.
The participants have to be created in the userGroup of the Competition "WhoRanMoreKilometers" in the main class.
After that, new activities can be added to the Competiton by using the prase: activity of <username> Is <activity> For <distance> In <duration>
The distance is added in kilometers and the duration in hours.


[![Build Status](https://travis-ci.com/FizziR/KilometersInOneYear.svg?branch=main)](https://travis-ci.com/FizziR/KilometersInOneYear) [![Coverage Status](https://coveralls.io/repos/github/FizziR/KilometersInOneYear/badge.svg?branch=main)](https://coveralls.io/github/FizziR/KilometersInOneYear?branch=main)
