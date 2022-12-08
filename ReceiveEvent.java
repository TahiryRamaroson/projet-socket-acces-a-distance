package client;

import java.awt.*;
import java.io.BufferedReader;

public class ReceiveEvent extends Thread{
    BufferedReader reader;

    public ReceiveEvent(BufferedReader read){
        this.setReader(read);
        start();
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                Robot robot = new Robot();
                if(this.reader.readLine().equalsIgnoreCase("mousePressed")) robot.mousePress(Integer.parseInt(this.reader.readLine()));
                if(this.reader.readLine().equalsIgnoreCase("mouseReleased")) robot.mouseRelease(Integer.parseInt(this.reader.readLine()));
                if(this.reader.readLine().equalsIgnoreCase("mouseMoved")) robot.mouseMove(Integer.parseInt(this.reader.readLine()), Integer.parseInt(this.reader.readLine()));
                if(this.reader.readLine().equalsIgnoreCase("keyPressed")) robot.keyPress(Integer.parseInt(this.reader.readLine()));
                if(this.reader.readLine().equalsIgnoreCase("keyReleased")) robot.keyRelease(Integer.parseInt(this.reader.readLine()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } 

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}
