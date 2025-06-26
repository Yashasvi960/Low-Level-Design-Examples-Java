This package is to implement low level design of social network. 

User class: User class is to get name of the user and their connections. 
            Connection is the set of Users. you can add user as connection too here.

SocialNetwork class: This class is to add user and add connections to the user. 
            It also has a method to get the User.

Social Network Analysis: Provides method for analyzing the network, such as finding mutual connections.

SocialNetworkApplication. This is the main class in which a new network is created, and some users are added to it. After that new Connected is added to all the Users. Finally, the mutual connections are being returned.

The design pattern being followed in the SocialNetwork and SocialNetworkAnalysis implementation is the Facade Pattern.  
Explanation:
Facade Pattern: It provides a simplified interface to a complex subsystem. In this case:
SocialNetwork acts as the subsystem managing users and connections.
SocialNetworkAnalysis provides a simplified interface for analyzing the network, such as finding mutual connections.
This separation of concerns makes the system modular and easier to extend or maintain.
