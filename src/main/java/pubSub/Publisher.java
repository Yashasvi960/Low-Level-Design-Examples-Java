package pubSub;

public class Publisher {

    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public void publishMessage(Topic topic, String message) {
        System.out.println("published message by publisher+ " + name + ": " + message);
        topic.publishMessage(message);
    }
}
