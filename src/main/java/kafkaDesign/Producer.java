package kafkaDesign;

public class Producer {

    private Broker broker;

    public Producer(Broker broker) {
        this.broker = broker;
    }

    public void sendMessage(String topicName, Message message) {
        Topic topic = broker.getTopic(topicName);
        if(topic!=null) {
            topic.publishMessage(message);
            System.out.println("Message sent to topic: " + topicName + ", Key: " + message.getKey() + ", Value: " + message.getValue());
        } else  {
            System.out.println("Topic not found: " + topicName);
        }
    }
}
