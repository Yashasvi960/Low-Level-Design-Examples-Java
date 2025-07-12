package kafkaDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic {

    private String name;
    private Map<Integer, List<Message>> partitions;
    private int partitionCount;

    public Topic(String name, int partitionCount) {
        this.name = name;
        this.partitionCount = partitionCount;
        partitions = new HashMap<>();

        for(int i = 0; i<partitionCount; i++) {
            partitions.put(i, new ArrayList<>());
        }
    }

    public String getName() {
        return name;
    }

    public void publishMessage(Message message) {
        int partition = getPartition(message.getKey());
        partitions.get(partition).add(message);
    }

    public List<Message> getMessagesFromPartition(int partition) {
        return partitions.getOrDefault(partition, new ArrayList<>());
    }

    public int getPartition(String key) {
        return Math.abs(key.hashCode())%partitionCount;
    }

}
