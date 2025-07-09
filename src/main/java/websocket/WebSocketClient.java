package websocket;

public class WebSocketClient {

    private String clientId;

    private WebSocketServer server;

    public WebSocketClient(String clientId, WebSocketServer server) {
        this.clientId = clientId;
        this.server = server;
    }

    public String getClientId() {
        return clientId;
    }

    public void sendMessage(Message message) {
        System.out.println("Client " + clientId + " sending message: " + message.getContent());
        server.broadCastMessage(message);
    }

    public void recieveMessage(Message message) {
        System.out.println("Client " + clientId + " received message: " + message.getContent());
    }
}
