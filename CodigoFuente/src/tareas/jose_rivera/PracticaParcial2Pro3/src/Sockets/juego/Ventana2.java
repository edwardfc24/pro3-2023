package Sockets.juego;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Ventana2 extends JFrame {

//aqui va el cliente
    protected Socket socket;
    protected static final Logger logger = LogManager.getLogger(Ventana2.class);

    protected BufferedReader entrada;
    protected PrintWriter salida;

    protected JLabel lbTitulo = new JLabel("Bienvenido!");
    protected JLabel lbNombre2 = new JLabel("Jugador 2");

    public JTextField txtJugador2 = new JTextField();
    private JButton btnJugar = new JButton("Jugar");
    private JPanel panelMultijugador = new JPanel();

    public Ventana2() {
        super("Inicio - jugador2");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void recibirRespuesta() throws IOException {
        String respuesta = this.entrada.readLine();
        System.out.println(respuesta);
    }

    public void enviarMensaje(String mensaje, String servidor, int puerto) {
        try {
            socket = new Socket(servidor, puerto);
            logger.info("Conexion realizada");
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
            // Gestion mensajes
            salida.println(mensaje);
            this.recibirRespuesta();
            //this.desconectarServidor();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void desconectarServidor() {
        try {
            this.entrada.close();
            this.salida.close();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initComponents() {
        panelMultijugador.setLayout(null);
        lbTitulo.setBounds(200, 100, 80, 50);

        lbNombre2.setBounds(100, 200, 80, 30);
        txtJugador2.setBounds(180, 200, 120, 25);
        btnJugar.setBounds(200, 250, 80, 30);
        add(panelMultijugador);
        panelMultijugador.add(lbTitulo);
        panelMultijugador.add(lbNombre2);
        panelMultijugador.add(txtJugador2);
        panelMultijugador.add(btnJugar);

        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnJugar) {
                    enviarMensaje(txtJugador2.getText(),"localhost",8080);
                    setVisible(false);
                    Jugador2 juego = new Jugador2();
                }
            }
        });
    }

    public static void main(String[] args) {
        new Ventana2().setVisible(true);
        new Jugador1().setVisible(true);
    }
}



