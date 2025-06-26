package loadBalancer;

import java.util.List;

public class LoadBalancer {

    private final LoadBalancingStrategy strategy;
    private final List<Server> server;

    public LoadBalancer(LoadBalancingStrategy strategy, List <Server> server) {
        this.strategy = strategy;
        this.server = server;
    }

    public void forwardRequest(RequestClass request) {
        Server serverSelected = strategy.selectServer(server);
        serverSelected.handleRequest(request);
    }
}
