package socialNetworkAnalysis;

import java.util.HashMap;
import java.util.Map;

public class SocialNetwork {

    private final Map<String, User> users;

    public SocialNetwork() {
        users = new HashMap<>();
    }

    public void addUser(String name) {
        users.putIfAbsent(name, new User(name));
    }

    public void addConnection(String user1, String user2) {
        User u1 = users.get(user1);
        User u2 = users.get(user2);

        if(u1!=null && u2!=null && !u1.equals(u2)) {
            u1.addConnection(u2);
        }
    }

    public User getUser(String name) {
        return users.get(name);
    }


}
