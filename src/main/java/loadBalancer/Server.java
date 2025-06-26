package loadBalancer;

public class Server {

    private final String name;

    public Server(String name) {
        this.name = name;
    }

    public void handleRequest(RequestClass request) {
        System.out.println("Handling request on server: " + request.getData());
    }

    public String getName() {
        return name;
    }
}
