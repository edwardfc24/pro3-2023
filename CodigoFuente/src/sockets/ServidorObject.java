package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorObject {
    private ServerSocket servidor;
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;
    private boolean escucharMensajes;

    public ServidorObject() {
        this.escucharMensajes = true;
        this.encenderServidor();
    }

    private void encenderServidor() {
        try {
            servidor = new ServerSocket(8080);
            System.out.println("Servidor Encendido");
            while (this.escucharMensajes) {
                socket = servidor.accept();
                System.out.println("Cliente conectado");
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
        System.out.println("Servidor: " + mensaje);
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
}









