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

public class VentanaCliente extends JFrame {

    private static final Logger logger = LogManager.getLogger(Cliente.class);
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    private PanelLocal local;
    private PanelDisparos visitante;

    public VentanaCliente() throws IOException {

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
        // Agregar los paneles al panel principal
        panelPrincipal.add(local);
        panelPrincipal.add(visitante);
        // Agregar el panel principal al centro del BorderLayout
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        this.setVisible(true);

        //////////******implementamos sokets******////////////

        try {
            socket = new Socket("localhost", 6060); // Conectar al servidor en la misma máquina
            logger.info("Conexion establecida. ");

            // Establecer los flujos de entrada y salida de objetos
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());

            // Crear y enviar otro array de posiciones

            int[][] otroArrayPosiciones = {
                    {2, 3},
                    {5, 6},
                    {8, 9}
            };

            salida.writeObject(otroArrayPosiciones);
            salida.flush();

            // Esperar y recibir la respuesta del servidor
            Object respuesta = entrada.readObject();
            logger.info("Respuesta del servidor: " + respuesta);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (entrada != null)
                    entrada.close();
                if (salida != null)
                    salida.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /*
    public void conectarAlServidor() {
        try {
            socket = new Socket("localhost", 6060); // Conectar al servidor en la misma máquina
            logger.info("Soket conectado ");

            // Establecer los flujos de entrada y salida de objetos
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());

            // Crear y enviar el array de posiciones
            int[][] posiciones = {
                    {0, 0},
                    {1, 2},
                    {4, 6}
            };

            enviarPosiciones(posiciones);

            // Esperar y recibir la respuesta del servidor
            Object respuesta = recibirRespuesta();
            logger.info("respuesta del servidor: ");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            desconectar();
        }
    }

    private void enviarPosiciones(int[][] posiciones) {
        try {
            salida.writeObject(posiciones);
            salida.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object recibirRespuesta() {
        try {
            return entrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void desconectar() {
        try {
            if (entrada != null)
                entrada.close();
            if (salida != null)
                salida.close();
            if (socket != null)
                socket.close();
            logger.warn("soket desconectado");

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
    }*/
}
