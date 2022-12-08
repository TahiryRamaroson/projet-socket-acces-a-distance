package server;

import java.awt.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JPanel;
import server.ReceiveScreen;
import server.TraitementServer;
import affichage.TheScreen;
import listener.Screenlistener;

public class Server {
    public static void main(String[] args) {        
        try {
            ServerSocket server;
            Socket client;
            server = new ServerSocket(9999);
            client = server.accept();
            TraitementServer traitement = new TraitementServer(client);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}