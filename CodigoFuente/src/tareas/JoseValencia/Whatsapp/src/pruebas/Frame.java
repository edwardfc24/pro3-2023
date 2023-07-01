package pruebas;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private PanelCentral granPanel;
    public Frame() throws HeadlessException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
        this.setSize(500, 500);
        this.getContentPane().setBackground(Color.BLUE);

        granPanel= new PanelCentral();
        this.add(granPanel);
        this.setVisible(true);
    }

    ////Getter and setter////
    public PanelCentral getGranPanel() {
        return granPanel;
    }
    public void setGranPanel(PanelCentral granPanel) {
        this.granPanel = granPanel;
    }
    /////////////////////////
}
