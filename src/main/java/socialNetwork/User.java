package socialNetwork;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;
    private Set<User> friends;

    public User(String name) {
        this.name = name;
        friends = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addFriends(User friend) {
        friends.add(friend);
    }

    public Set<User> getFriends() {
        return friends;
    }
}
