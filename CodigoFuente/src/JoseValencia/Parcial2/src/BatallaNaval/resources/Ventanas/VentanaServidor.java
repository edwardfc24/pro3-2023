package BatallaNaval.resources.Ventanas;

import BatallaNaval.resources.Patron.Cliente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class VentanaServidor extends JFrame {
    private static final Logger logger = LogManager.getLogger(Cliente.class);
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    private PanelLocal local;
    private PanelDisparos visitante;
    private JPanel jPanel;

    public VentanaServidor(){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,300);
        this.getContentPane().setLayout(new BorderLayout());
        JPanel panelPrincipal = new JPanel(new GridLayout(1, 2));
        panelPrincipal.setBackground(Color.WHITE);
        // Crear los dos paneles que ocuparán la mitad de la ventana cada uno
        local = new PanelLocal();
        local.setBackground(Color.yellow);
        visitante = new PanelDisparos();
        visitante.setBackground(Color.red);

        jPanel= new JPanel();
        jPanel.setBounds(0,0,400,300);

        // Agregar los paneles al panel principal
        panelPrincipal.add(local);
        panelPrincipal.add(visitante);
        // Agregar el panel principal al centro del BorderLayout
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        this.setVisible(true);



        ///////////******* implementamos los sokets********//////////

        try {
            if (0==local.getContadorBarcos()) {
                panelPrincipal.add(jPanel);
            }


            serverSocket = new ServerSocket(6060); // Puerto de escucha
            logger.info("Servidor iniciado, esperando conexion...");

            clientSocket = serverSocket.accept(); // Aceptar la conexión entrante
            logger.info("Cliente conectdo.");

            // Establecer los flujos de entrada y salida de objetos
            salida = new ObjectOutputStream(clientSocket.getOutputStream());
            entrada = new ObjectInputStream(clientSocket.getInputStream());

            // Escuchar constantemente los mensajes del cliente
            while (true) {
                Object mensaje = entrada.readObject();
                logger.info("Mensaje recivido: " + mensaje );

                // Realizar alguna acción con el mensaje recibido
                if (mensaje instanceof int[][]) {
                    int[][] posiciones = (int[][]) mensaje;

                    // Hacer algo con las posiciones recibidas
                    //

                    // Enviar una respuesta al cliente
                    String respuesta = "Respuesta del servidor";
                    salida.writeObject(respuesta);
                    salida.flush();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (entrada != null)
                    entrada.close();
                if (salida != null)
                    salida.close();
                if (clientSocket != null)
                    clientSocket.close();
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /*
    public void iniciarServidor() {
        try {
            serverSocket = new ServerSocket(6060); // Puerto de escucha
            logger.info("servidor inciado");

            clientSocket = serverSocket.accept(); // Aceptar la conexión entrante
            logger.info("cliente conectado");

            // Establecer los flujos de entrada y salida de objetos
            salida = new ObjectOutputStream(clientSocket.getOutputStream());
            entrada = new ObjectInputStream(clientSocket.getInputStream());

            // Escuchar constantemente los mensajes del cliente
            while (true) {
                Object mensaje = entrada.readObject();
                logger.info("mensaje recibido : " +  mensaje);

                // Realizar alguna acción con el mensaje recibido
                if (mensaje instanceof int[][]) {
                    int[][] posiciones = (int[][]) mensaje;

                    // Hacer algo con las posiciones recibidas
                    procesarPosiciones(posiciones);

                    // Enviar una respuesta al cliente
                    String respuesta = "Respuesta del servidor";
                    enviarRespuesta(respuesta);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    private void procesarPosiciones(int[][] posiciones) {
        // Realizar alguna operación con las posiciones recibidas
    }

    private void enviarRespuesta(Object respuesta) {
        try {
            salida.writeObject(respuesta);
            salida.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void desconectar() {
        try {
            if (entrada != null)
                entrada.close();
            if (salida != null)
                salida.close();
            if (clientSocket != null)
                clientSocket.close();
            if (serverSocket != null)
                serverSocket.close();
            System.out.println("Desconectado del cliente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
