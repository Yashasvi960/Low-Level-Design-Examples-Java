package socialNetwork;

import java.util.HashMap;
import java.util.Map;

public class Graph {

    Map<String,User> userMap;

    public Graph() {
        userMap = new HashMap<>();
    }

    public void addUser(String userName){
        User user  = new User(userName);
        userMap.put(userName, user);
    }

    public User getUser(String userName) {
        return userMap.get(userName);
    }

    public void addFriendship(String userName1, String userName2) {
        User user1 = new User(userName1);
        User user2 = new User(userName2);

        user1.addFriends(user2);
        user2.addFriends(user1);
    }
}
