package server;

import java.awt.*;
import server.ReceiveScreen;
import affichage.TheScreen;
import listener.Screenlistener;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TraitementServer extends Thread{
    Socket socket;
    
    public TraitementServer(Socket so){
        this.setSocket(so);
        start();
    }

    @Override
    public void run() {
        super.run();
        try {
            TheScreen screen = new TheScreen((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            DataInputStream input = new DataInputStream(this.getSocket().getInputStream());
            double clientWidth = input.readDouble();
            double clientHeight = input.readDouble();
            ReceiveScreen receive = new ReceiveScreen(new DataInputStream(this.getSocket().getInputStream()), screen.getContenir());
            Screenlistener listen = new Screenlistener(this.getSocket(), screen.getContenir(), clientWidth, clientHeight);
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

}
