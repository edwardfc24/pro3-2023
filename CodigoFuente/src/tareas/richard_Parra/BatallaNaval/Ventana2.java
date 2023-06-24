package Sockets.BatallaNaval;

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
import java.util.Random;

public class Ventana2 extends JFrame {
    private Socket socket;
    private static final Logger logger = LogManager.getLogger(Ventana2.class);

    private BufferedReader entrada;
    private PrintWriter salida;

    private JLabel lbTitulo = new JLabel("Bienvenido!");
    private JLabel lbNombre2 = new JLabel("Jugador 2");

    public JTextField txtJugador2 = new JTextField();
    private JButton btnJugar = new JButton("Jugar");
    //private JPanel panelMultijugador = new JPanel();
    private JButton[][] btnTabla = new JButton[10][10];
    private int intentos = 0;
    private int contador = 0;

    public Ventana2() {
        this.setTitle("Inicio - jugador2");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        initComponents();
        cargarListeners();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    private void initComponents() {
        setLayout(null);
        lbTitulo.setBounds(200, 100, 80, 50);

        lbNombre2.setBounds(100, 200, 80, 30);
        txtJugador2.setBounds(180, 200, 120, 25);
        btnJugar.setBounds(200, 250, 80, 30);
        //add(panelMultijugador);
        add(lbTitulo);
        add(lbNombre2);
        add(txtJugador2);
        add(btnJugar);
    }

    private void cargarListeners() {
        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbTitulo.setVisible(false);
                lbNombre2.setVisible(false);
                txtJugador2.setVisible(false);
                btnJugar.setVisible(false);
                enviarMensaje("localhost", 8012);
                for (int filas = 0; filas < 10; filas++) {
                    for (int columnas = 0; columnas < 10; columnas++) {
                        JButton btn1 = crearBotonMatriz(filas, columnas);
                        btnTabla[filas][columnas] = btn1;

                    }
                }
                repaint(); // Actualiza la interfaz gráfica
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
    private void reiniciarJuego() {
        for (int filas = 0; filas < 10; filas++) {
            for (int columnas = 0; columnas < 10; columnas++) {
                JButton btn2 = btnTabla[filas][columnas];
                btn2.setText("");
            }
        }
    }

    private void verificarResultado() {
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

    private void recibirRespuesta() throws IOException {
        String respuesta = this.entrada.readLine();
        System.out.println(respuesta);
    }

    public void enviarMensaje(String servidor, int puerto) {
        try {
            socket = new Socket(servidor, puerto);

            logger.info("Conexion realizada");
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);
            // Gestion mensajes
            //salida.println(mensaje);
            this.recibirRespuesta();

//this.desconectarServidor

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

    public static void main(String[] args) {
        new Ventana2();
    }
}
