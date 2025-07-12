package socialNetwork;

import java.util.*;
import java.util.Set;

public class RecommendationEngine {

    Map<String, Integer> recommendationMap;

    public RecommendationEngine() {

        recommendationMap = new HashMap<>();
    }

    public Map<String, Integer> recommendFriend(User user) {
        Set<User> friends = user.getFriends();

        for(User friend: friends) {
            Set<User> mutualFriends = friend.getFriends();
            for(User mutualFriend: mutualFriends) {
                if(!recommendationMap.containsKey(mutualFriend.getName()) &&!mutualFriend.getName().equals(user.getName())) {
                    recommendationMap.put(mutualFriend.getName(),1);
                } else {
                    recommendationMap.put(mutualFriend.getName(), recommendationMap.get(mutualFriend.getName()) + 1);
                }
            }

        }
        return recommendationMap;
    }
}
