In the LoadBalancer package, we are implementing a simple load balancing application in which the requests are being forwarded to the selected servers. This class is using strategy design pattern


LoadBalancer class - This class is to get the selected strategy and get the selected server and forwarding a request to them.

LoadBalancerStrategy - This interface is just for different strategies a load balancer might take to select the server. It takes a list of servers and select one out of them. In this example, we just have taken round robin strategy.

RoundRobinStrategy - This class implements the strategy for selecting the server. In this class, there is a function called getServer which is just iterating through the list of server and return the next server in the list.

Server - This class is just a simple class for getting the name of the server. 

Request = This class is just a simple class to intiate a request and get the data.

In loadBalancerMain, we are sending 10 requests and just printing the request data when they are being forwarded to the server.

