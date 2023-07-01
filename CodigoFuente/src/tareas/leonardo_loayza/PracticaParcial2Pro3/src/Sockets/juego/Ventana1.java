package Sockets.juego;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ventana1 extends JFrame {
    //aqui va el servidor
    private JLabel lbTitulo = new JLabel("Multijugador!");

    private JLabel lbNombre1 = new JLabel("Jugador 1");
    public JTextField txtJugador1 = new JTextField();
    private JButton btnJugar = new JButton("Jugar");
    private JPanel panelMultijugador = new JPanel();

    private ServerSocket servidor;
    private static final Logger logger = LogManager.getLogger(Ventana1.class);
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;
    private boolean escucharMensajes;
    private Jugador1 jugador1 = new Jugador1();

    public Ventana1() {

        super("Inicio-jugador 1");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        this.escucharMensajes = true;
        jugador1.setVisible(false);
    }
    private void encenderServidor() {
        try {
            servidor = new ServerSocket(8080);
            logger.info("Servidor Encendido");
            logger.info("Esperando al jugador 2...");
            while (this.escucharMensajes) {
                socket = servidor.accept();
                logger.info("Cliente conectado");
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                salida = new PrintWriter(socket.getOutputStream(), true);
                this.gestionarMensajes();
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private void gestionarMensajes() throws IOException {
        String mensaje = this.entrada.readLine();
        logger.info("Servidor: " + mensaje);
        this.salida.println("Respuesta Servidor: Mensaje recibido");
    }

    public void apagarServidor() {
        try {
            this.escucharMensajes = false;
            this.entrada.close();
            this.salida.close();
            this.socket.close();
            this.servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void initComponents() {
        panelMultijugador.setLayout(null);
        lbTitulo.setBounds(200, 100, 80, 50);
        lbNombre1.setBounds(100, 150, 80, 30);
        txtJugador1.setBounds(180, 150, 120, 25);


        btnJugar.setBounds(200, 250, 80, 30);
        add(panelMultijugador);

        panelMultijugador.add(lbTitulo);
        panelMultijugador.add(lbNombre1);
        panelMultijugador.add(txtJugador1);

        panelMultijugador.add(btnJugar);

        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnJugar) {
                    encenderServidor();
                    setVisible(false);
                    jugador1.setVisible(true);
                }
            }
        });


    }
    public static void main(String[] args) {
        new Ventana1().setVisible(true);
    }
}
