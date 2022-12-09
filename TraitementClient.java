package client;

import java.net.Socket;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.*;

public class TraitementClient extends Thread{
    Socket socket;
    Robot robot;
    Rectangle rectangle;

    public TraitementClient(Socket so, Robot ro, Rectangle rect){
        this.setSocket(so);
        this.setRobot(ro);
        this.setRectangle(rect);
        start();
    }

    @Override
    public void run() {
        super.run();
        try {
            SendScreen screen = new SendScreen(this.getSocket(), this.getRobot(), this.getRectangle());
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.getSocket().getInputStream()));
            ReceiveEvent event = new ReceiveEvent(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    public Robot getRobot() {
        return robot;
    }
    public void setRobot(Robot robot) {
        this.robot = robot;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

}
