package pruebas;

import Chats.Observable;
import Chats.Observador;

import javax.swing.*;
import java.awt.*;

public class PanelPersona extends JPanel implements Observable, Observador {
    private JLabel mensajes;
    private JTextField txtmensaje;
    private JButton btnenviar;

    public PanelPersona(){
        this.setSize(250, 200);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        txtmensaje= new JTextField();
        txtmensaje.setBounds(0, 210, 50,140);

        btnenviar= new JButton( );
        btnenviar.setBounds(150,200,20,50);

        this.add(txtmensaje);
        this.add(btnenviar);

        /////Añadir labels a los paneles/////
        //this.add(createLabel("chat de persona ",Color.black, Color.blue ));
        //this.add(createLabel("mensaje 2 de persona ",Color.black, Color.blue ));
        ////////////////////////////////////

        this.setVisible(true);
    }

    ////interface////
    @Override
    public JLabel mostrarMensaje(String mensaje) {
        //retorna nulo por que no tengo que mandar
        return null;
    }
    @Override
    public void suscribir(Observador observer) {

    }
    @Override
    public void desuscribir(Observador observer) {

    }
    @Override
    public void notificarObservadores(String mensaje) {

    }
    ////////////////

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
