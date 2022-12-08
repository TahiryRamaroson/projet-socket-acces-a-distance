package client;

import java.awt.Rectangle;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.Dimension;
import java.awt.*;
import java.net.Socket;
import client.SendScreen;
import client.ReceiveEvent;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket;
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rect = new Rectangle(dimension);
            clientSocket = new Socket("192.168.88.207",9999);
            Robot robot = new Robot();
            SendScreen screen = new SendScreen(clientSocket, robot, rect);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ReceiveEvent event = new ReceiveEvent(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}