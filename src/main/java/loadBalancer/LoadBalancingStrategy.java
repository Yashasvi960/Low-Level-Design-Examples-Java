package loadBalancer;

import java.util.List;

public interface LoadBalancingStrategy {

    Server selectServer(List<Server> server);
}
