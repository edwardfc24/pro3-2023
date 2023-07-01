package pruebas;

import javax.swing.*;
import java.awt.*;

public class PanelChats extends JPanel {
    private JLabel mensajes;

    public PanelChats(){
        this.setSize(250, 200);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /////Añadir labels a los paneles/////
        this.add(createLabel("chat de varios", Color.black, Color.blue ));
        ////////////////////////////////////

        this.setVisible(true);
    }

    //////metodo//////
    public static JLabel createLabel(String text, Color textColor, Color backgroundColor) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.setForeground(textColor);
        label.setBackground(backgroundColor);
        return label;
    }
    /////////////////

    /////getter and setter/////
    public JLabel getMensajes() {
        return mensajes;
    }
    public void setMensajes(JLabel mensajes) {
        this.mensajes = mensajes;
    }
    ///////////////////////////
}