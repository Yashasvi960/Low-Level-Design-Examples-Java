package loadBalancer;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinStrategy implements LoadBalancingStrategy{
    private final AtomicInteger currentIndex = new AtomicInteger(0);

    @Override
    public Server selectServer(List<Server> server) {
        int index = currentIndex.getAndUpdate(i -> (i+1)%server.size());
        return server.get(index);
    }
}
