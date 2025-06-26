package loadBalancer;

import java.util.List;

public class LoadBalancerMain {

    public static void main(String[] args) {
        List<Server> server = List.of(new Server("server1"), new Server("server2"), new Server(("server3")));
        LoadBalancingStrategy strategy = new RoundRobinStrategy();
        LoadBalancer loadBalancer = new LoadBalancer(strategy, server);

        for(int i = 0; i<10; i++) {
            RequestClass request = new RequestClass("Request"+ (i+1));
            loadBalancer.forwardRequest(request);
        }

    }
}
