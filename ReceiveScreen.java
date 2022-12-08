package server;

import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ReceiveScreen extends Thread {

 	JPanel panel;
 	DataInputStream input;
 	Image image;

  	public ReceiveScreen(DataInputStream in, JPanel pan) {
    	input = in;
    	panel = pan;
    	start();
  	}

  	public void run() {
    	try {
    	  	//Read screenshots of the client and then draw them
    	  	while (true) {
    	    	byte[] bytes = new byte[4096 * 4096];
    	    	int count = 0;
				
				do {
					count += input.read(bytes, count, bytes.length - count);
					System.out.println(count);
				} while(!(count > 4 && bytes[count - 2] == (byte) -1 && bytes[count - 1] == (byte) -39));

    	    	image = ImageIO.read(new ByteArrayInputStream(bytes));
    	    	image = image.getScaledInstance(panel.getWidth(), panel.getHeight(), Image.SCALE_FAST);

    	    	//Draw the received screenshots

    	    	Graphics graphics = panel.getGraphics();
    	    	graphics.drawImage(image, 0, 0, panel.getWidth(), panel.getHeight(), panel);
				
    		}
    	} catch (IOException ex) {
    	  	ex.printStackTrace();
    	}
  	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public DataInputStream getInput() {
		return input;
	}

	public void setInput(DataInputStream input) {
		this.input = input;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
