package Sockets.BatallaNaval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente extends JFrame {
    JPanel panel_Menu = new JPanel();
    JTextField txtUsuario = new JTextField();

    public Cliente() {
        super("Cliente");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(700, 250);
        setSize(400, 520);
        init();
    }

    public void init() {
        // Configuración del panel de menú
        panel_Menu.setLayout(null);
        panel_Menu.setBackground(new Color(2, 19, 38));
        add(panel_Menu);

        // Configuración de la imagen de fondo
        JLabel lbFoto = new JLabel(new ImageIcon("C:\\Users\\Richard-P\\IdeaProjects\\richard_parra\\ProgramacionIII\\img\\barco.png"));
        lbFoto.setBounds(0, 0, 380, 480);
        lbFoto.setVisible(true);
        panel_Menu.add(lbFoto, null);

        // Configuración de la etiqueta de nombre de usuario
        JLabel lbPersona = new JLabel("Nombre:");
        lbPersona.setForeground(Color.white);
        lbPersona.setFont(new java.awt.Font("cooper black", 0, 24));
        lbPersona.setBounds(200, 300, 140, 50);
        lbFoto.add(lbPersona, null);

        // Configuración del campo de texto de usuario
        txtUsuario.setBounds(230, 350, 120, 25);
        txtUsuario.setOpaque(false);
        txtUsuario.setForeground(Color.white);
        lbFoto.add(txtUsuario, null);

        // Configuración del botón de aceptar
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setOpaque(false);
        btnAceptar.setBackground(new Color(0, 0, 0, 0));
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setBounds(230, 380, 120, 25);
        btnAceptar.setForeground(Color.white);
        lbFoto.add(btnAceptar, null);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                conectar();
            }
        });

    }
    //la conexión con el servidor
    public void conectar(){
        try {
            String id = txtUsuario.getText();

            Socket socket = new Socket("localhost", 8181);
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(id);
            String i = new DataInputStream(socket.getInputStream()).readUTF();
            if (i.equals("Ya estas registrado")) {
                JOptionPane.showMessageDialog(this, "YA ESTA REGISTRADO\n");
            } else {
                Tablero tablero = new Tablero(id, socket);
                this.dispose();
                tablero.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Cliente client = new Cliente();
        client.setVisible(true);
    }
}

