package socialNetwork;

import java.util.Map;

public class SocialNetworkMain {

    public static void main(String args[]) {

        Graph graph = new Graph();

        graph.addUser("Alice");
        graph.addUser("Bob");
        graph.addUser("Charlie");
        graph.addUser("David");

        graph.addFriendship("Alice", "Bob");
        graph.addFriendship("Bob", "Charlie");
        graph.addFriendship("Charlie", "David");

        RecommendationEngine engine = new RecommendationEngine();
        Map<String, Integer> map = engine.recommendFriend(graph.getUser("Alice"));

        for(Map.Entry<String ,Integer> entry: map.entrySet()) {
            System.out.println("Recommended friend: " + entry.getKey() + " with score: " + entry.getValue());
        }
    }
}
