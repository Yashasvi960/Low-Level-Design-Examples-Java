package socialNetworkAnalysis;

public class SocialNetworkMain {

    public static void main(String args[]) {
        SocialNetwork network = new SocialNetwork();
        network.addUser("Alice");
        network.addUser("Bob");
        network.addUser("Charlie");
        network.addUser("David");

        network.addConnection("Alice", "Bob");
        network.addConnection("Alice", "Charlie");
        network.addConnection("Bob", "Charlie");
        network.addConnection("Bob", "David");

        System.out.println("Mutual connection between Alice and Bob:");
        SocialNetworkAnalysis networkAnalysis = new SocialNetworkAnalysis();
        System.out.println(networkAnalysis.findMutualConnections(network, "Alice", "Bob"));
    }
}
