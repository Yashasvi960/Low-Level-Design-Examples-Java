package kafkaDesign;

import java.util.*;
public class Consumer {

    private Broker broker;

    public Consumer(Broker broker) {
        this.broker = broker;
    }
    public void consumeMessage(String topicName, int partition) {
        Topic topic  = broker.getTopic(topicName);
        if(topic!=null) {
            List<Message> messages = topic.getMessagesFromPartition(partition);
            for(Message message: messages) {
                System.out.println("Consumed message from topic: " + topicName + ", Partition: " + partition + ", Key: " + message.getKey() + ", Value: " + message.getValue());
            }
        } else {
            System.out.println("Topic not found: " + topicName);
        }
    }
}
