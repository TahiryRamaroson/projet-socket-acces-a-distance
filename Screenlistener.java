package listener;

import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

public class Screenlistener implements MouseListener, KeyListener, MouseMotionListener{
    PrintWriter writer;
    Socket socket;
    JPanel panel;


    public Screenlistener(Socket so, JPanel pan){
        try {
            this.setPanel(pan);
            this.setSocket(so);
            this.writer = new PrintWriter(this.getSocket().getOutputStream());
            this.getPanel().addMouseListener(this);
            this.getPanel().addMouseMotionListener(this);
            this.getPanel().addKeyListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {}

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        this.writer.println("mousePressed");
        int button = e.getButton();
        int xButton = 16;
        if (button == 3) xButton = 4;
        this.writer.println(xButton);
        this.writer.flush();
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        this.writer.println("mouseReleased");
        int button = e.getButton();
        int xButton = 16;
        if (button == 3) xButton = 4;
        this.writer.println(xButton);
        this.writer.flush();
        
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        this.writer.println("mouseMoved");
        this.writer.println(e.getX() * this.getPanel().getWidth() / Toolkit.getDefaultToolkit().getScreenSize().width);
        this.writer.println(e.getX() * this.getPanel().getWidth() / Toolkit.getDefaultToolkit().getScreenSize().height);
        this.writer.flush();
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.writer.println("keyPressed");
        this.writer.println(e.getKeyCode());
        this.writer.flush();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.writer.println("keyReleased");
        this.writer.println(e.getKeyCode());
        this.writer.flush();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {}


    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    
    
}
