# DesignPatterns
Displaying knowlege and usage of design patterns. Also for personal exprimentation


##Factory Patten
The factory method pattern is a creational pattern that uses factory methods to deal with the problem of creating objects without having to specify the exact class of the object that will be created
###Implementation
I have implemented a CD factory which creates CDs base on a name, the implementation of the Tracks are not ideal since each track is a hardcoded object(which is not even singlton). The track should be created based on a datasource forexample a database. 
The point is that the implementation of the Factory CD can create cd which can get/create track from what ever the CD implementation.
