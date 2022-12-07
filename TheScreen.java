package affichage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TheScreen extends JFrame {
    JPanel contenir = new JPanel();

    public TheScreen(int width, int height){

        this.add(contenir);

        setTitle("TheScreen");
        setSize(width, height);
        setVisible(true);
    }

    public JPanel getContenir() {
        return contenir;
    }

    public void setContenir(JPanel contenir) {
        this.contenir = contenir;
    }

}
