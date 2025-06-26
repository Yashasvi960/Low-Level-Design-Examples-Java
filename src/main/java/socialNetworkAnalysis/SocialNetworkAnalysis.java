package socialNetworkAnalysis;

import java.util.Set;
import java.util.stream.Collectors;

public class SocialNetworkAnalysis {

    public Set<String> findMutualConnections(SocialNetwork network, String user1, String user2) {
        User u1 = network.getUser(user1);
        User u2 = network.getUser(user2);

        if(u1==null || u2==null) {
            return Set.of();
        }

        return u1.getConnections().stream()
                .filter(u2.getConnections()::contains)
                .map(User::getName)
                .collect(Collectors.toSet());
    }
}
