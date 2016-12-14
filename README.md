# DesignPatterns
Displaying knowlege and usage of design patterns. Also for personal exprimentation


##Factory Patten
The factory method pattern is a creational pattern that uses factory methods to deal with the problem of creating objects without having to specify the exact class of the object that will be created
###Implementation
I have implemented a CD factory which creates CDs base on a name, the implementation of the Tracks are not ideal since each track is a hardcoded object(which is not even singlton). The track should be created based on a datasource forexample a database. 
The point is that the implementation of the Factory CD can create cd which can get/create track from what ever the CD implementation.

##Command Patten
The command pattern is a behavioral design pattern in which an object is used to encapsulate all information needed to perform an action or trigger an event at a later time
###Implementation
I have implemented a Media play which has a list of commands, [PLAY,NEXT,PREV]. Which excutes the relevant function.

### Use of Java 8
Before java 8 alot of extra classes would have been created which implemented the command interface now with java 8, i had one method in the interface which allowed it to be a functional interface. This meant i did not need to create additional classes because i could just create anonymous function which would do the command.
There was also a combination of the factory patten to create the addition functions.