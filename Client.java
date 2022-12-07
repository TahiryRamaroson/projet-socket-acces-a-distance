package client;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Dimension;
import java.awt.*;
import java.net.Socket;
import client.SendScreen;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket;
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rect = new Rectangle(dimension);
            clientSocket = new Socket("localhost",9999);
            Robot robot = new Robot();
            SendScreen screen = new SendScreen(clientSocket, robot, rect);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}