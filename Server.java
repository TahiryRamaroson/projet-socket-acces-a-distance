package server;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JPanel;
import server.ReceiveScreen;
import affichage.TheScreen;

public class Server {
    public static void main(String[] args) {        
        try {
            ServerSocket server;
            Socket client;
            server = new ServerSocket(9999);
            client = server.accept();
            TheScreen screen = new TheScreen(1000, 1000);
            ReceiveScreen receive = new ReceiveScreen(client.getInputStream(), screen.getContenir());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}