package pubSub;

public class Subscriber {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void receiveMessage(String message) {
        System.out.println("subscriber name :"+name + "message");
    }
}
