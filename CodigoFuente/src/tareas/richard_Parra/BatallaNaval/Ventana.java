package Sockets.BatallaNaval;

import Sockets.ServidorObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Ventana extends JFrame implements ActionListener {
    private JLabel lbEtiqueta = new JLabel();
    private JLabel lbNombre = new JLabel("Nombre: ");
    private JTextField txtNombre = new JTextField();
    private JButton btnInicio = new JButton("Iniciar");
    private JButton btnCancelar = new JButton("Cancelar");
    private JButton[][] btnTabla = new JButton[10][10];
    private JButton btnReiniciar = new JButton("Reiniciar");
    private JLabel lbJugador = new JLabel("Jugador: ");
    private JLabel lbJugador2 = new JLabel("Jugador 2: ");
    private String nombreJugador = "";
    private int contador = 0;
    private int intentos = 0;
    private ServerSocket servidor;
    private static final Logger logger = LogManager.getLogger(Ventana.class);
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;
    //private boolean escucharMensajes = true;
    
    public Ventana(){

        this.setSize(550, 580);
        this.setTitle("BATALLA NAVAL");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
        cargarListeners();
        this.setVisible(true);
        btnReiniciar.setVisible(false);
        lbJugador.setVisible(false);
        lbJugador2.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    public void iniciarComponentes(){
        //setLayout(new GridLayout(10, 10)); // Establecer GridLayout
        setLayout(null);
        lbEtiqueta.setText("BATALLA NAVAL");
        lbEtiqueta.setBounds(80, 85, 800, 80);
        //lbEtiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        lbEtiqueta.setForeground(Color.BLACK);
        lbEtiqueta.setFont(new Font("cooper black", Font.PLAIN, 40));

        lbNombre.setBounds(137,280,100,20);
        txtNombre.setBounds(135,310,200,20);
        btnInicio.setBounds(185, 350, 100, 30);
        btnCancelar.setBounds(185, 380, 100, 30);
        btnReiniciar.setBounds(185, 480, 100, 30);
        lbJugador.setBounds(40, 505, 100, 30);
        lbJugador2.setBounds(300, 480, 100, 30);

        this.add(lbEtiqueta);
        this.add(lbNombre);
        this.add(txtNombre);
        this.add(btnInicio);
        this.add(btnCancelar);
        this.add(btnReiniciar);
        this.add(lbJugador);
        this.add(lbJugador2);
        //btnInicio.addActionListener(this);
    }
    private void cargarListeners(){
        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbEtiqueta.setVisible(false);
                lbNombre.setVisible(false);
                txtNombre.setVisible(false);
                btnInicio.setVisible(false);
                btnCancelar.setVisible(false);
                try {
                    servidor = new ServerSocket(8012);
                    logger.info("Jugador 1 conectado");
                    logger.info("Esperando respuesta del jugador 2");
                        socket = servidor.accept();
                        logger.info("Jugador 2 conectado");
                        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        salida = new PrintWriter(socket.getOutputStream(),true);
                }catch (IOException error){
                    error.printStackTrace();
                }
                for (int filas = 0; filas < 10; filas++) {
                    for (int columnas = 0; columnas < 10; columnas++) {
                        JButton btn1 = crearBotonMatriz(filas,columnas);
                        btnTabla[filas][columnas] = btn1;
                        nombreJugador = txtNombre.getText();
                        lbJugador.setText("Jugador: " + nombreJugador);
                    }
                }
                btnReiniciar.setVisible(true);
                lbJugador.setVisible(true);
                lbJugador2.setVisible(true);
                repaint();
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apagarServidor();
            }
        });

        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJuego();
                verificarResultado();
            }
        });
    }
    private JButton crearBotonMatriz(int indice, int aux) {
        JButton btn = new JButton();
        // Configura el tamaño y posición del botón en función de los índices
        btn.setBounds(25 + aux * 45, 25 + indice * 45, 45, 45);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JButton btn1 = (JButton) e.getSource();

                // Verificar el texto actual del botón
                if (btn1.getText().isEmpty()) {
                    // Asignar "X" o "O" de forma aleatoria
                    Random random = new Random();
                    if (random.nextBoolean()) {
                        btn1.setText("X");
                    } else {
                        btn1.setText("O");
                    }
                    contador++;
                    intentos++;
                    verificarResultado();
                }
            }
        });
        // Agrega el ActionListener
        //btn.addActionListener(this);
        // Agrega el botón al JFrame
        this.add(btn);
        return btn;
    }



    // metodo para limpiar o reinicar mi tabla matriz
    private void reiniciarJuego(){
        for (int filas = 0; filas < 10; filas++) {
            for (int columnas = 0; columnas < 10; columnas++) {
                JButton btn2 = btnTabla[filas][columnas];
                btn2.setText("");
            }
        }
    }

    private void verificarResultado(){
        if (intentos >= 3) {
            boolean gano = true;
            // Verificar si se cumple la condición de victoria
            if (btnTabla[0][0].getText().equals("O") && btnTabla[0][1].getText().equals("O") && btnTabla[0][2].getText().equals("O")) {
                gano = true;
            }
            // Verificar si se cumple la condición de derrota
            if (btnTabla[0][0].getText().equals("X") && btnTabla[0][1].getText().equals("X") && btnTabla[0][2].getText().equals("X")) {
                gano = false;
            }

            // Mostrar mensaje correspondiente
            if (gano) {
                JOptionPane.showMessageDialog(this, "¡Has ganado el juego!");
            } else {
                JOptionPane.showMessageDialog(this, "¡Has perdido el juego!");
            }
        }
    }
    public void apagarServidor(){
//este tiene que enviar mensaje
        try {
            this.entrada.close();
            this.salida.close();
            this.socket.close();
            this.servidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public static void main(String[] args) {
        Ventana ventana = new Ventana();
    }
}
