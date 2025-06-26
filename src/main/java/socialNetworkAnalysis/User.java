package socialNetworkAnalysis;

import java.util.*;
public class User {

    private final String name;
    private final Set<User> connections;

    public User(String name) {
        this.name = name;
        connections = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<User> getConnections() {
        return connections;
    }

    public void addConnection(User user) {
        connections.add(user);
    }

}
