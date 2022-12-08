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
                if(this.reader.readLine().equalsIgnoreCase("mousePressed")){
                    double nb = Double.valueOf(this.reader.readLine());
                    robot.mousePress((int)nb);
                } 
                if(this.reader.readLine().equalsIgnoreCase("mouseReleased")){
                    double nb = Double.valueOf(this.reader.readLine());
                    robot.mouseRelease((int)nb);
                } 
                if(this.reader.readLine().equalsIgnoreCase("mouseMoved")){
                    double x = Double.valueOf(this.reader.readLine());
                    double y = Double.valueOf(this.reader.readLine());
                    robot.mouseMove((int)x, (int)y);
                }
                 
                if(this.reader.readLine().equalsIgnoreCase("keyPressed")){
                    double nb = Double.valueOf(this.reader.readLine());
                    robot.keyPress((int)nb);
                } 
                if(this.reader.readLine().equalsIgnoreCase("keyReleased")){
                    double nb = Double.valueOf(this.reader.readLine());
                    robot.keyRelease((int)nb);
                } 
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
