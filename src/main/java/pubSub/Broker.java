package pubSub;

import java.util.HashMap;
import java.util.Map;

public class Broker {

    Map<String, Topic> topics;
    public Broker() {
        topics = new HashMap<>();
    }

    public Topic createTopic(String topicName) {
        Topic topic = new Topic(topicName);
        topics.put(topicName, topic);

        return topic;
    }

    public Topic getTopic(String topicName) {
        return topics.get(topicName);
    }

}
