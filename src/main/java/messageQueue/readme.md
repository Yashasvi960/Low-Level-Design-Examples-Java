In this package, we implement a message queue system that allows a synchronous communication between producer and consumer

A message Queue is created to having a certain capacity, in this class they have 2 functions, enqueue and dequeue.
A producer is created which produces 10 messages and add it to queue. but if the queue is full, it waits for the consumer to consume the messages.

Then a consumer is created which consumes the messages from the queue. If the queue is empty, it waits for the producer to produce the messages.

In the main class, the producer and consumer threads are created and a messageQueue is added to both of them, and then the threads are started, which starts the run function int the producer and consumer classes


