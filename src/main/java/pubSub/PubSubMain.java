package pubSub;

public class PubSubMain {

    public static void main(String args[]) {

        Broker broker = new Broker();
        Publisher publisher  = new Publisher("Publisher1");
        Subscriber subscriber1 = new Subscriber("Subscriber1");
        Subscriber subscriber2 = new Subscriber("Subscriber2");


        Topic newsTopic = broker.createTopic("newsTopic");
        Topic sportsTopic = broker.createTopic("sportsTopic");

        newsTopic.addSubscriber(subscriber1);
        sportsTopic.addSubscriber(subscriber2);

        publisher.publishMessage(newsTopic, "Breaking News: newsTopic!");
        publisher.publishMessage(sportsTopic, "Sports Update: sportsTopic!");

    }
}
