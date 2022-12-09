package client;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

public class SendScreen extends Thread {

  	Socket socket;
  	Robot robot;
  	Rectangle rectangle;
  	DataOutputStream output;
	double width;
	double height;

  	public SendScreen(Socket socket, Robot robot, Rectangle rect) {
    	this.socket = socket;
    	this.robot = robot;
    	rectangle = rect;
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setHeight(dimension.getHeight());
		this.setWidth(dimension.getWidth());
    	start();
  	}

  	public void run(){
    	try {
    	  	output = new DataOutputStream(socket.getOutputStream());
			output.writeDouble(this.getWidth());
			output.writeDouble(this.getHeight());

			while (true) {
				BufferedImage image = robot.createScreenCapture(rectangle);
			  	ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image,"jpeg",baos);
				byte[] bytes = ByteBuffer.allocate(4).putInt(baos.size()).array();
				System.out.println(bytes.length);
				output.write(bytes);
				output.write(baos.toByteArray());
				output.flush();
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

	public DataOutputStream getOutput() {
		return output;
	}

	public void setOutput(DataOutputStream output) {
		this.output = output;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
