package Chats;

import pruebas.PanelPersona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameConObserver extends JFrame{
    private JTextField txtnotificar;
    private JButton btnenviar;

    private JPanel chats;


    public FrameConObserver(Persona observable, Persona observer1, Persona observer2){
        observable.suscribir(observer1);
        observable.suscribir(observer2);

        this.setTitle(observable.getNombre());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(500, 500);
        this.setLayout(null);

        ////panel chats
        chats= new JPanel();
        chats.setBounds(0,0,500,400);
        chats.setBackground(Color.WHITE);
        this.add(chats);
        //////////

        txtnotificar= new JTextField();
        txtnotificar.setBounds(10, 400, 380,30);
        this.add(txtnotificar);

        btnenviar = new JButton("enviar");
        btnenviar.setBounds(400, 400, 70,30);
        btnenviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*//enviamos la notificacion al observer
                //observable.notificar(txtnotificar.getText());
                //chats.add(observable.mostrarMensaje(observable.getNombre()+" : "+txtnotificar.getText()), new BoxLayout(chats, BoxLayout.Y_AXIS));
                //observable.notificar(txtnotificar.getText());
                //txtnotificar.setText("");
                */
            }
        });
        this.add(btnenviar);


        this.setVisible(true);
    }

    //////getter y setter //////
    public JTextField getTxtnotificar() {
        return txtnotificar;
    }
    public void setTxtnotificar(JTextField txtnotificar) {
        this.txtnotificar = txtnotificar;
    }
    public JButton getBtnenviar() {
        return btnenviar;
    }
    public void setBtnenviar(JButton btnenviar) {
        this.btnenviar = btnenviar;
    }
    public JPanel getChats() {
        return chats;
    }
    public void setChats(JPanel chats) {
        this.chats = chats;
    }
    ////////////////////////////
}
