package kafkaDesign;

public class KafkaMain {

    public static void main(String args[]) {

        Broker broker = new Broker();
        broker.createTopic("exampleTopic", 3);
        Producer producer = new Producer(broker);
        producer.sendMessage("exampleTopic", new Message("key1", "value1"));
        producer.sendMessage("exampleTopic", new Message("key2", "value2"));

        Consumer consumer = new Consumer(broker);
        consumer.consumeMessage("exampleTopic", 0);
        consumer.consumeMessage("exampleTopic", 1);
    }
}
