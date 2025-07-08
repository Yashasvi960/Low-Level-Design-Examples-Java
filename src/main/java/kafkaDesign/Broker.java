package kafkaDesign;

import java.util.HashMap;
import java.util.Map;

public class Broker {

    private Map<String, Topic> topics;

    public Broker() {
        this.topics = new HashMap<>();
    }

    public void createTopic(String topicName, int partitionCount) {
        topics.put(topicName, new Topic(topicName, partitionCount));
    }

    public Topic getTopic(String topicName) {
        return topics.get(topicName);
    }
}
