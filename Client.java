package client;

import java.awt.Rectangle;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.Dimension;
import java.awt.*;
import java.net.Socket;
import client.TraitementClient;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket;
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rect = new Rectangle(dimension);
            clientSocket = new Socket("169.254.124.227",9999);
            Robot robot = new Robot();
            TraitementClient traitement = new TraitementClient(clientSocket, robot, rect);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}