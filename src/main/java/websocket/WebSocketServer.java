package websocket;

import java.util.ArrayList;
import java.util.List;

public class WebSocketServer {

    public List<WebSocketClient> clientList;

    public WebSocketServer() {
        clientList = new ArrayList<>();
    }

    public void connectClient(WebSocketClient client) {
        clientList.add(client);
        System.out.println("Client connected: " + client.getClientId());
    }

    public void disconnectClient(WebSocketClient client) {
        clientList.remove(client);
        System.out.println("Client disconnected: " + client.getClientId());
    }

    public void broadCastMessage(Message message) {
        for(WebSocketClient client: clientList) {
            client.recieveMessage(message);
        }
    }
}
