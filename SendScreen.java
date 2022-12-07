package client;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;

public class SendScreen extends Thread {

  	Socket socket;
  	Robot robot;
  	Rectangle rectangle;
  	OutputStream output;

  	public SendScreen(Socket socket, Robot robot, Rectangle rect) {
    	this.socket = socket;
    	this.robot = robot;
    	rectangle = rect;
    	start();
  	}

  	public void run(){
    	try {
    	  	output = socket.getOutputStream();
			while (true) {
				BufferedImage image = robot.createScreenCapture(rectangle);
			  	ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image,"png",baos);
				byte[] bytes = baos.toByteArray();
				System.out.println(bytes.length);
				output.write(bytes);
			  	Thread.sleep(1);
		  	}
    	} catch (IOException ex) {
    	  	ex.printStackTrace();
    	} catch (InterruptedException e) {
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

	public OutputStream getOutput() {
		return output;
	}

	public void setOutput(OutputStream output) {
		this.output = output;
	}
}
