package pubSub;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String name;
    private List<Subscriber> subscriberList;

    public Topic(String name) {
        this.name = name;
        subscriberList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    public void publishMessage(String message) {
        for(Subscriber subscriber: subscriberList) {
            subscriber.receiveMessage(message);
        }
    }

}
