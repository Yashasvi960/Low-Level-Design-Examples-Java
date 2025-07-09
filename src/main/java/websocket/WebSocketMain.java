package websocket;

public class WebSocketMain {

    public static void main(String[] args) {
        WebSocketServer server = new WebSocketServer();
        WebSocketClient client1 = new WebSocketClient("client1", server);
        WebSocketClient client2 = new WebSocketClient("client2", server);

        server.connectClient(client1);
        server.connectClient(client2);

        client1.sendMessage(new Message("Hello from client1!"));
        client2.sendMessage(new Message("Hello from client2!"));

        server.disconnectClient(client1);
        server.disconnectClient(client2);

    }
}
