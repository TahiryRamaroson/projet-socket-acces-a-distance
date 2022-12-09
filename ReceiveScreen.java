package server;

import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;

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
			super.run();
    	
    	  	while (true) {
    	    	byte[] bytes = new byte[4];
				this.input.readFully(bytes);
    	    	int size = ByteBuffer.wrap(bytes).asIntBuffer().get();
				byte[] finalbyte = new byte[size];
				int inread = 0;
				int next = 0;
				while (inread < size && (next = input.read(finalbyte, inread, size - inread)) > 0) {
					inread += next;
				}

    	    	image = ImageIO.read(new ByteArrayInputStream(finalbyte));
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
