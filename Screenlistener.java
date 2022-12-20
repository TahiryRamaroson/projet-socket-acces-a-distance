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
    double clientWidth;
    double clientHeight;


    public Screenlistener(Socket so, JPanel pan, double width, double height){
        try {
            this.setClientHeight(height);
            this.setClientWidth(width);
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
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        this.writer.println("mousePressed");
        int button = e.getButton();
        System.out.println(e.getButton());
        int RobotButton = 16;
        if (button == 3) RobotButton = 4;
        this.writer.println(RobotButton);
        this.writer.flush();
        System.out.println("mousePressed");
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        this.writer.println("mouseReleased");
        int button = e.getButton();
        System.out.println(e.getButton());
        int RobotButton = 16;
        if (button == 3) RobotButton = 4;
        this.writer.println(RobotButton);
        this.writer.flush();
        System.out.println("mouseReleased");
        
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        this.writer.println("mouseMoved");
        this.writer.println(e.getX() * ((int)this.clientWidth) / this.getPanel().getWidth());
        this.writer.println(e.getY() * ((int)this.clientHeight) / this.getPanel().getHeight());
        this.writer.flush();
        System.out.println("move");
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        this.writer.println("keyPressed");
        this.writer.println(e.getKeyCode());
        this.writer.flush();
        System.out.println("keypressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.panel.requestFocus();
        this.panel.setFocusable(true);
        this.writer.println("keyReleased");
        this.writer.println(e.getKeyCode());
        this.writer.flush();
        System.out.println("keyReleased");
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

    public double getClientWidth() {
        return clientWidth;
    }

    public void setClientWidth(double clientWidth) {
        this.clientWidth = clientWidth;
    }

    public double getClientHeight() {
        return clientHeight;
    }

    public void setClientHeight(double clientHeight) {
        this.clientHeight = clientHeight;
    }

    
    
}
